object TexasHoldemApp extends App {
  def run(): Unit = {

    val player1 = new Player(name = "Luci")
    val players = Array(player1)
    var roundNumber = 1

    val round1 = new Round(players: Array[Player])
    round1.start()
  }

  run()
}
