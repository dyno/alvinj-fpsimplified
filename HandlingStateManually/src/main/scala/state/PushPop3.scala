package state

/**
  * This code shows an example of `push` and `pop`
  * functions that work with a Scala `List`.
  *
  * This code is not currently shown in the book.
  */
object PushPop3 extends App {

  def push[A](xs: List[A], a: A): List[A] = a :: xs
  def pop[A](xs: List[A]): (A, List[A])   = (xs.head, xs.tail)

  val s1 = List(4, 5, 6)
  val s2 = push(s1, 3) //List(3, 4, 5, 6)
  val s3 = push(s2, 2) //List(2, 3, 4, 5, 6)
  val s4 = push(s3, 1) //List(1, 2, 3, 4, 5, 6)

  println(s"s4 = $s4")

  val (head1, s5) = pop(s4)
  println(s"popped '$head1' off the queue, remaining elements are $s5")
  println(s"s5 = $s5") //s5 = List(2, 3, 4, 5, 6)

  val (head2, s6) = pop(s5)
  println(s"popped '$head2' off the queue, remaining elements are $s6")
  println(s"s6 = $s6") //s6 = s6 = List(3, 4, 5, 6)

}
