package copy

object NestedCopy1 extends App {

  val hannahsName = Name(
      firstName = "Hannah",
      mi = "C",
      lastName = "Jones"
  )

  // create hannah1
  val hannah1 = User(
      id = 1,
      name = hannahsName,
      phone = "907-555-1212",
      email = "hannah@hannahjones.com",
      billingInfo = BillingInfo(
          creditCards = Seq(
              CreditCard(
                  name = hannahsName,
                  number = "1111111111111111",
                  month = 3,
                  year = 2020,
                  cvv = "123"
              )
          )
      )
  )
  println(hannah1)

  // hannah2
  val hannah2 = hannah1.copy(phone = "720-555-1212")
  println("\nhannah2: new phone")
  println(hannah2)

  // hannah3: new last name
  val newName = hannah2.name.copy(lastName = "Smith")
  val hannah3 = hannah2.copy(name = newName)
  println("\nhannah3: new last name")
  println(hannah3)

  // hannah4
  val oldCC   = hannah3.billingInfo.creditCards(0)
  val newCC   = oldCC.copy(name = newName)
  val newCCs  = Seq(newCC)
  val hannah4 = hannah3.copy(billingInfo = BillingInfo(newCCs))
  println("\nhannah4: new name on cc")
  println(hannah4)

}

case class BillingInfo(
        creditCards: Seq[CreditCard]
)

case class Name(
        firstName: String,
        mi: String,
        lastName: String
)

case class User(
        id: Int,
        name: Name,
        billingInfo: BillingInfo,
        phone: String,
        email: String
)

case class CreditCard(
        name: Name,
        number: String,
        month: Int,
        year: Int,
        cvv: String
)
