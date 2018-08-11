package v2_simple_oop

import common._
import scala.collection.mutable.ArrayBuffer

class Pizza {

    var crustSize: CrustSize = MediumCrustSize
    var crustType: CrustType = RegularCrustType

    // no need for `toppings` to be a `var`; `ArrayBuffer` is mutable
    val toppings = ArrayBuffer[Topping]()

    def addTopping(t: Topping): Unit = { toppings += t }
    def removeTopping(t: Topping): Unit = { toppings -= t }
    def removeAllToppings(): Unit = { toppings.clear() }

    def getPrice(
        toppingsPrices: Map[Topping, Money],
        crustSizePrices: Map[CrustSize, Money],
        crustTypePrices: Map[CrustType, Money]
    ): Money = ???

}

