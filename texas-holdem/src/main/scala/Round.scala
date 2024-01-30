class Round(players: Array[Player]) {

  val table = new Table
  val dealer = new Dealer(table)

  def start() = {
    dealer.dealHoleCardsTo(players)
    players.map { player =>
      Display.cardsOf(player)
    }

    // Player choice, starting with small blind and betting

    dealer.dealFlopCards() // Flop
    dealer.burnAndDeal() // Turn
    dealer.burnAndDeal() // River
    Display.cardsOf(table)
  }
}
