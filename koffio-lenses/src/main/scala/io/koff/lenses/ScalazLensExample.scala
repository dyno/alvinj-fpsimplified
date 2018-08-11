package io.koff.lenses

import io.koff.model._

import scalaz.Lens

/**
 * Example of usage of scalaz lens
 */
object ScalazLensExample extends App{
  /**
   * At first we should define lens like:
   */

  val siteInfoRatingLens = Lens.lensu[SiteInfo, Double](
    (info, value) => info.copy(userRating = value),
    _.userRating
  )

  /**
   * The first type parameter is needed to set in which class(`MainClass`)
   * we will change value and the second type parameter defines
   * the class(`FieldClass`) of the field which we will change with the lens.
   *
   * As you can see we should also send two functions to `lensu(...)` method.
   * The first function defines how to change `MainClass` using a new value.
   * The second function is used to get value of the field which we want to change.
   */

  /**
   * In order to make possible changes of `userRating` field directly in `User` object we should create additional lens
   */

  val generalInfoSiteInfoLens = Lens.lensu[GeneralInfo, SiteInfo](
    (general, site) => general.copy(siteInfo = site),
    _.siteInfo
  )

  val userGeneralInfoLens = Lens.lensu[User, GeneralInfo](
    (user, info) => user.copy(generalInfo = info),
    _.generalInfo
  )

  /**
   * and compose them in the chain `User.generalInfo -> GeneralInfo.siteInfo -> SiteInfo.userRating`.
   * We can use different approaches:
   *  `>=>` - alias for `andThen(...)` method
   *  `<=<` - alias for `compose(...)` method
   *
   * Example below:
   */

  //andThen
  val userRatingLens1 = userGeneralInfoLens >=> generalInfoSiteInfoLens >=> siteInfoRatingLens
  val userRatingLens2 = userGeneralInfoLens.andThen(generalInfoSiteInfoLens).andThen(siteInfoRatingLens)

  //compose
  val userRatingLens3 = siteInfoRatingLens <=< generalInfoSiteInfoLens <=< userGeneralInfoLens
  val userRatingLens4 = siteInfoRatingLens.compose(generalInfoSiteInfoLens).compose(userGeneralInfoLens)

  {
    val user = ProblemExample.user

    //same operations
    println(userRatingLens1.set(user, 1).generalInfo.siteInfo.userRating)
    println(userRatingLens2.set(user, 2).generalInfo.siteInfo.userRating)
    println(userRatingLens3.set(user, 3).generalInfo.siteInfo.userRating)
    println(userRatingLens4.set(user, 4).generalInfo.siteInfo.userRating)
  }

  /**
   * If you want to change `isConfirmed` to true in each address as it is described in the introduction example then I should
   * use a little different operator: `=>=` - alias for `mod(...)` method
   * This operator get value using lens, modify it and create a new object with a changed value.
   */
  val userBillInfoLens = Lens.lensu[User, BillInfo](
    (user, info) => user.copy(billInfo = info),
    _.billInfo
  )

  val billInfoAddressesLens = Lens.lensu[BillInfo, Seq[Address]](
    (info, addresses) => info.copy(addresses = addresses),
    _.addresses
  )

  val isConfirmedLens = (userBillInfoLens >=> billInfoAddressesLens) =>= { _.map(_.copy(isConfirmed = true)) }

  {
    val user = ProblemExample.user
    println(isConfirmedLens(user).billInfo.addresses)
  }

  /**
   * That is how we can use scalaz.Lens. It is quite hard and
   * we will reduce amount of the code only if we have very complex nesting and implement enough lens to compose them.
   * But now we have a notion about how we can use scalaz.Lens
   */
}
