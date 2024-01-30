trait CardHolder {
  var display: Array[Card]
}

class Table (
              override var display: Array[Card] = Array[Card]()
            ) extends CardHolder


class Player(
              override var display: Array[Card] = Array[Card](),
              val name: String
            ) extends CardHolder {
}


