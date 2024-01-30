import scala.util.Random

case class Card(suit: String, rank: String, value: Int)

object Deck {
  def produceNewShuffledDeck(): Seq[Card] = {
    val suits : Array[String] = Array[String]("Spades", "Clubs", "Hearts", "Diamonds")
    val values : Array[Int] = Array[Int](1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)
    val rank : Array[String] = Array[String]("Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King")
    val ranksAndvalues: Array[(String, Int)] = rank.zip(values)

    Random.shuffle(suits.flatMap { suit =>
      ranksAndvalues.map { rankAndValue =>
        Card(suit, rankAndValue._1, rankAndValue._2)
      }
    }.toSeq)
  }
}
