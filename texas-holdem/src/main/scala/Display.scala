object Display {
  def cardsOf(cardHolder: CardHolder): Unit = {
    cardHolder match {
      case player: Player => print(s"${player.name}'s hand: ")
      case table: Table => print("Table: ")
    }
    cardHolder.display.map {
      card => print(s"${card.rank} of ${card.suit}, ")
    }
  }
}
