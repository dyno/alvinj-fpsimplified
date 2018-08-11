package io_examples.v1

import java.io.File
import io_examples.common.Control.using
import scala.util.Try

/**
 * All of these methods return instances of `Try`.
 */
object FileUtils {

    def readTextFileAsString(filename: String): Try[String] =
        Try {
            val lines = using(io.Source.fromFile(filename)) { source =>
                (for (line <- source.getLines) yield line).toList
            }
            lines.mkString("\n")
        }

    /**
     * This method shows what the return signature would look like
     * if you wrap a `Try` with an `IO`.
     */
    def readTextFileAsStringIO(filename: String): IO[Try[String]] = {
        IO(readTextFileAsString(filename))
    }


    /**
      * these are just here so i can see what these types look like
      * in the scaladoc. run the sbt `doc` command to see the scaladoc
      * for yourself.
      */
    def copyFile(srcFile: File, destFile: File): Try[Boolean] = ???
    def readFileToByteArray(file: File): Try[Array[Byte]] = ???
    def readFileToString(file: File): Try[String] = ???
    def readFileToString(file: File, encoding: String): Try[String] = ???
    def readLines(file: File, encoding: String): Try[List[String]] = ???
    def sizeOf(file: File): Try[BigInt] = ???
    def sizeOfDirectory(directory: File): Try[BigInt] = ???

}



