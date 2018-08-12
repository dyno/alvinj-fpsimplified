package io_examples.v2

import java.io.File
import io_examples.common.Control.using
import scala.util.Try

/**
  * In this package, I create `IO` as a type alias for `Try`,
  * and then use `IO` as the return type for these functions.
  */
object FileUtils2 {

  def readTextFileAsString(filename: String): IO[String] =
    Try {
      val lines = using(io.Source.fromFile(filename)) { source =>
        (for (line <- source.getLines) yield line).toList
      }
      lines.mkString("\n")
    }

  /**
    * these are just here so i can see what these types look like
    * in the scaladoc. run the sbt `doc` command to see the scaladoc
    * for yourself.
    */
  def copyFile(srcFile: File, destFile: File): IO[Boolean]       = ???
  def readFileToByteArray(file: File): IO[Array[Byte]]           = ???
  def readFileToString(file: File): IO[String]                   = ???
  def readFileToString(file: File, encoding: String): IO[String] = ???
  def readLines(file: File, encoding: String): IO[List[String]]  = ???
  def sizeOf(file: File): IO[BigInt]                             = ???
  def sizeOfDirectory(directory: File): IO[BigInt]               = ???

}
