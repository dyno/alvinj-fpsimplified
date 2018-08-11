package v2_simple_oop

import scala.collection.mutable.ArrayBuffer

class Order {

    // an order contains a list of pizzas
    val pizzas = ArrayBuffer[Pizza]()

    // could be a constructor parameter *if* you always create
    // a customer before creating an order
    var customer: Customer = null

    def addPizzaToOrder(p: Pizza): Unit = {
        pizzas += p
    }

    def removePizzaFromOrder(p: Pizza): Unit = {
        pizzas -= p
    }

    // TODO
    //def calculateOrderPrice(): Money = ???
    def getBasePrice(): Money = ???
    def getTaxes(): Money = ???
    def getTotalPrice(): Money = ???

}
