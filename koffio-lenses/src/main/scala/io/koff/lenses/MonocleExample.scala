package io.koff.lenses

import io.koff.model.{ProblemExample, SiteInfo, GeneralInfo, User}

/**
 * Example of monocle usage
 */
object MonocleExample {

  def main(args: Array[String]) {
    /**
     * `Monocle` is not just a lens library. It also contains logic for work with prisms.
     *  But here we will only look at a lens's part of the library.
     */
    //Main features

    /**
     * As other libraries `Monocle` supports lens creation:
     * Common way to create lens is very similar to scalaz.Lens - we should create separate lens for our types
     */
    {
      import monocle.Lens

      //create lens
      val generalInfoLens = Lens[User, GeneralInfo](_.generalInfo)(info => user => user.copy(generalInfo = info))
      val siteInfoLens = Lens[GeneralInfo, SiteInfo](_.siteInfo)(site => general => general.copy(siteInfo = site))
      val userRatingLens =
        Lens[SiteInfo, Double](_.userRating)(rating => siteInfo => siteInfo.copy(userRating = rating))

      //and compose them together
      val changeRatingLens = generalInfoLens.composeLens(siteInfoLens).composeLens(userRatingLens)
      val user = ProblemExample.user

      val updatedUser = changeRatingLens.set(20)(user)
      println(updatedUser.generalInfo.siteInfo.userRating)
    }

    /**
     * Simpler way is to use macros
     */
    {
      import monocle.macros.GenLens
      val changeRatingLens = GenLens[User](_.generalInfo.siteInfo.userRating)
      val plus100RatingLens = changeRatingLens.modify(_ + 100)

      val user = ProblemExample.user
      val updatedUser = plus100RatingLens(user)
      println(updatedUser.generalInfo.siteInfo.userRating)
    }

    //Additional features
    /**
     * There is support of annotation `@Lenses` which generate `monocle.Lenses` for all fields of a case class.
     */
    {
      import monocle.macros.Lenses
      @Lenses case class Address(name: String)
      @Lenses case class Person(address: Address)

      val lens = Person.address
      val addressNameLens = Person.address composeLens Address.name
      val changeNameFunc = addressNameLens.modify(_.toUpperCase)(_:Person)

      val person = Person(Address("person_address"))
      val updatedPerson = changeNameFunc(person)

      println(updatedPerson)
    }
  }
}
