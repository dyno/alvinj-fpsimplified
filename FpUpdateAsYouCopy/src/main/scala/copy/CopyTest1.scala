package copy

object CopyTest1 extends App {

    println("--- Before Copy ---")
    val emily1 = Person("Emily", "Means")
    println(s"emily1 = $emily1")

    // emily got married
    println("\n--- After Copy ---")
    val emily2 = emily1.copy(lastName = "Walls")
    println(s"emily1 = $emily1")
    println(s"emily2 = $emily2")

}

case class Person (firstName: String, lastName: String)



