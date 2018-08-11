package v2_generic

object DebuggableGenericsWithFloats extends App {

    def f(a: Float): Debuggable[Float] = {
        val result = a / 10f
        Debuggable(result, s"f: multiply $a / 10 = $result\n")
    }

    def g(a: Float): Debuggable[Float] = {
        val result = a * 2f
        Debuggable(result, s"g: multiply $a * 2 = $result\n")
    }

    val finalResult = for {
        fRes <- f(100)
        gRes <- g(fRes)
    } yield s"result: $gRes"

    println(finalResult.message)
    println(s"Output is ${finalResult.value}")

}
