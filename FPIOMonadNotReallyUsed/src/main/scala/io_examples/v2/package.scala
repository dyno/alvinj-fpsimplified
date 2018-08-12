package io_examples

import scala.util.Try

package object v2 {

  type IO[A] = Try[A]

}
