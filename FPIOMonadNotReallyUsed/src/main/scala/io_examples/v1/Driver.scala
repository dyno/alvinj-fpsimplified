package io_examples.v1

import scala.util.{Failure, Success, Try}

/**
  * This example calls `readTextFileAsString`, which
  * returns the type, `Try[String]`.
  */
object Driver extends App {

    // intentionally use an invalid filename
    val passwdFile: Try[String] = FileUtils.readTextFileAsString("/etc/passwdFoo")

    passwdFile match {
        case Success(s) => println(s)
        case Failure(e) => println(e)
    }

}


