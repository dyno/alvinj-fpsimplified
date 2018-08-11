package io.koff.model

/**
 * Lets assume that we have a model like that:
 */

/**
 * Represents info about user in a system
 * @param id user id
 * @param generalInfo info how to show user on a site
 * @param billInfo user contacts
 */
case class User(id: UserId, generalInfo: GeneralInfo, billInfo: BillInfo)

case class UserId(value: Long)
case class GeneralInfo(email: Email,
                       password: String,
                       siteInfo: SiteInfo,
                       isEmailConfirmed: Boolean = false,
                       phone: String,
                       isPhoneConfirmed: Boolean = false)
case class SiteInfo(alias: String, avatarUrl: String, userRating: Double = 0.0d)
case class Email(value: String)
case class BillInfo(addresses: Seq[Address], name: Name)
case class Name(firstName: String, secondName: String)
case class Address(country: Country, city: City, street: String, house: String, isConfirmed: Boolean = false)
case class City(name: String)
case class Country(name: String)

object ProblemExample {
  val user = User(
    id = UserId(1),

    generalInfo = GeneralInfo(
      email = Email("detective@example.com"),
      password = "qweqweqwe",
      siteInfo = SiteInfo(
        alias = "True_detectiv",
        avatarUrl = "http://example.com/smart_avatar"
      ),
      phone = "(+1)999-888-77-66"
    ),

    billInfo = BillInfo(
      addresses = Seq(
        Address(
          country = Country("United Kingdom"),
          city = City("London"),
          street = "Baker Street",
          house = "221b"
        ),
        Address(
          country = Country("France"),
          city = City("Paris"),
          street = "Ethel Street",
          house = "10"
        )
      ),
      name = Name("Sherlock", "Holmes")
    )
  )

  def main(args: Array[String]) {
    /**
     * If we want to increase `userRating` in this model then we will have to write this:
     */

    {
      val updatedUser = user.copy(
        generalInfo = user.generalInfo.copy(
          siteInfo = user.generalInfo.siteInfo.copy(
            userRating = user.generalInfo.siteInfo.userRating + 1
          )
        )
      )

      println("updatedRating: " + updatedUser.generalInfo.siteInfo.userRating)
    }

    /**
     * And we have to write such a code to confirm all of the addresses in BillInfo
     */

    {
      val updatedAddresses = user.billInfo.addresses.map(_.copy(isConfirmed = true))
      val updatedUser = user.copy(
        billInfo = user.billInfo.copy(addresses = updatedAddresses)
      )

      println("updatedAddresses: " + updatedUser.billInfo.addresses)
    }


    /**
     * If we increase a level of nesting in our structures then we will considerably increase amount of a code like this.
     * In such cases lens give a cleaner way to make changes in nested structures.
     * Using quicklens we can do it much simpler
     */

    {
      import com.softwaremill.quicklens._
      //update rating using quicklens
      val userWithRating = user.modify(_.generalInfo.siteInfo.userRating).using(_ + 1)

      //confirm all the addresses of a user with quicklens
      val userWithConfimedAddresses = user.modify(_.billInfo.addresses.each.isConfirmed).using(_ => true)
    }

    /**
     * Now we have base understanding of lens purpose.
     * In the next parts of this article we will see how to use each of the libraries from the list
     */
  }
}