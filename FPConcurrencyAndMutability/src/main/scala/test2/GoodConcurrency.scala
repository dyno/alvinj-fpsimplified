package test2

object GoodConcurrency extends App {

    val me = Person("Alvin", "Talkeetna", "Alaska")

    val t1 = new Thread {
        override def run {
            Thread.sleep(1000)
            // this code won't compile - Person is immutable
            //me.town = "Boulder"
            Thread.sleep(3000)
            // this code won't compile - Person is immutable
            //me.state = "Colorado"
        }
    }
    t1.start

    // more code here ...

}

case class Person (
    name: String,
    town: String,
    state: String
) {
    override def toString = s"name: $name, town: $town, state: $state"
}










