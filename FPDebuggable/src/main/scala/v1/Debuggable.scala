package v1

case class Debuggable(value: Int, message: String) {

  def map(f: Int => Int): Debuggable = {
    val newValue = f(value)
    Debuggable(newValue, message)
  }

  def flatMap(f: Int => Debuggable): Debuggable = {
    val newValue: Debuggable = f(value)
    Debuggable(newValue.value, message + "\n" + newValue.message)
  }

}

object Test extends App {

  val finalResult = for {
    fResult <- f(100)
    gResult <- g(fResult)
    hResult <- h(gResult)
  } yield hResult

  // added a few "\n" to make the output easier
  // to read
  println(s"value:   ${finalResult.value}\n")
  println(s"message: \n${finalResult.message}")

  def f(a: Int): Debuggable = {
    val result  = a * 2
    val message = s"f: a ($a) * 2 = $result."
    Debuggable(result, message)
  }

  def g(a: Int): Debuggable = {
    val result  = a * 3
    val message = s"g: a ($a) * 3 = $result."
    Debuggable(result, message)
  }

  def h(a: Int): Debuggable = {
    val result  = a * 4
    val message = s"h: a ($a) * 4 = $result."
    Debuggable(result, message)
  }
}
