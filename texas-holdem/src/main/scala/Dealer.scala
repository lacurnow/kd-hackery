import scala.util.Random

class Dealer(table: Table) {

  private var deckInPlay = Deck.produceNewShuffledDeck()

  def dealACardTo(cardHolder: CardHolder): Unit = {
    val card = getRandomCardFromDeck()
    cardHolder.display = cardHolder.display :+ card
  }

  def dealHoleCardsTo(players: Array[Player]): Unit = {
    players.foreach { player =>
      (1 to 2).foreach { _ =>
        dealACardTo(player)
      }
    }
  }

  def dealFlopCards(): Unit = {
    /*
    - Discard card from deck
    - Deal three cards onto table
     */
    deckInPlay = deckInPlay.drop(1)
    (1 to 3).foreach { _ =>
      dealACardTo(table)
    }
  }

  def burnAndDeal() : Unit = {
    /*
    - Discard card from deck
    - Deal another card onto table
     */
    deckInPlay = deckInPlay.drop(1)
    dealACardTo(table)
  }

  private def getRandomCardFromDeck() : Card = {
    val drawnCard = deckInPlay(Random.nextInt(deckInPlay.length))
    deckInPlay = deckInPlay.filter(_ != drawnCard)
    drawnCard
  }
}
