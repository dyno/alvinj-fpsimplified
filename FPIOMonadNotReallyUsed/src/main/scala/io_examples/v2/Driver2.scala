package io_examples.v2

import io_examples.common.MiscUtils
import scala.util.{Failure, Success}

/**
  * In this package, I create `IO` as a type alias for `Try`.
  * (See the package object *v2.scala* for that declaration.)
  *
  * This example calls `readTextFileAsString`, which
  * returns the type, `IO[String]` (thanks to that type alias).
 */
object Driver2 extends App {

    // intentionally use an invalid filename
    val passwdFile: IO[String] = FileUtils2.readTextFileAsString("/etc/passwdFoo")

    passwdFile match {
        case Success(s) => println(s)
        case Failure(e) => {
            val msg = MiscUtils.getFullStackTrace(e)
            println(msg)
        }
    }

}
