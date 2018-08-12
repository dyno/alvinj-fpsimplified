package v1_true_oop

import common._
import scala.collection.mutable.ArrayBuffer

/**
  * This class shows an example of a “real” OOP design.
  */
class Pizza {

  type Money = BigDecimal

  // private fields
  private var _crustSize: CrustSize = MediumCrustSize
  private var _crustType: CrustType = RegularCrustType
  private val _toppings             = ArrayBuffer[Topping]()

  def getCrustSize = _crustSize
  def setCrustSize(cs: CrustSize) {
    _crustSize = cs
  }

  def getCrustType = _crustType
  def setCrustType(ct: CrustType) {
    _crustType = ct
  }

  def getToppings = _toppings
  def addTopping(t: Topping) {
    _toppings += t
  }

  // other built-in methods
  def removeTopping(t: Topping) {
    _toppings -= t
  }

  def removeAllToppings() {
    _toppings.clear()
  }

  def getPrice(): Money = ???

}
