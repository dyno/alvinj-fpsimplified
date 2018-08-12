import cats.effect.IO

object IOMonadHelloWorld extends App {
  val hello: IO[Unit] = IO { println("Hello, world") }
  hello.unsafeRunSync()
}
