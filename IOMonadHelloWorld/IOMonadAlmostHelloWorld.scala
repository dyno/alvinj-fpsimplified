import cats.effect.IO

object IOMonadAlmostHelloWorld extends App {    
    val hello = IO { println("Hello, world") }
}

