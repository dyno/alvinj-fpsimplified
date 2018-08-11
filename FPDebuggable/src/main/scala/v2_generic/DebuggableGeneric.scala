package v2_generic

/**
  * The purpose of this class is to show a version of the `Debuggable`
  * class that takes a generic `value` (whereas the previous versions
  * required that `value` be an `Int`).
  */
case class Debuggable[A](value: A, message: String) {

    def map[B](f: A => B): Debuggable[B] = {
        val nextValue = f(value)
        Debuggable(nextValue, message)
    }

    def flatMap[B](f: A => Debuggable[B]): Debuggable[B] = {
        val nextValue = f(value)
        Debuggable(nextValue.value, message + nextValue.message)
    }
}

object DebuggableGenericExample extends App {

    def f(a: Int): Debuggable[Int] = {
        val result = a * 2
        Debuggable(result, s"f: multiply $a * 2 = $result\n")
    }

    def g(a: Int): Debuggable[Int] = {
        val result = a * 3
        Debuggable(result, s"g: multiply $a * 3 = $result\n")
    }

    def h(a: Int): Debuggable[Int] = {
        val result = a * 4
        Debuggable(result, s"h: multiply $a * 4 = $result\n")
    }

    val finalResult = for {
        fRes <- f(100)
        gRes <- g(fRes)
        hRes <- h(gRes)
    } yield s"result: $hRes"

    println(finalResult.message)
    println(s"Output is ${finalResult.value}")

}
