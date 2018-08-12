package test1

/**
  * Note: I use 1000+ ms for the time increments, but you can imagine
  * them being 10ms or 100ms.
  *
  * Output is like this:
  *
  *   time = 0:    name: Alvin, town: Talkeetna, state: Alaska
  *   time = 2169: name: Alvin, town: Boulder,   state: Alaska  <-- PROBLEM
  *   time = 4173: name: Alvin, town: Boulder,   state: Colorado
  *
  */
object SimpleBadConcurrency extends App {

  val me = new Person("Alvin", "Talkeetna", "Alaska")

  val t1 = new Thread {
    override def run {
      Thread.sleep(1000)
      me.town = "Boulder"
      Thread.sleep(3000)
      me.state = "Colorado"
    }
  }

  // start the thread
  t1.start

  println(s"1) $me")

  Thread.sleep(2000)
  println(s"2) $me")

  Thread.sleep(2000)
  println(s"3) $me")

}
