package io.koff.lenses

import io.koff.model.{GeneralInfo, ProblemExample, User}

/**
 * Example of usage of quicklens
 */
object QuickLensExample {
  def main(args: Array[String]) {
    /**
     * Use of scalaz.Lens is quite difficult
     * but if we are not afraid to use macros in a project we might use `quicklens` instead.
     *
     * You have already seen a simple example for `quicklens` so let's go deeper and see what else `quicklens` can do
     */

    /**
     * `Quicklens` has support of chain modifications which can be helpful if you want to change several fields at the same time
     */

    {
      import com.softwaremill.quicklens._
      val user = ProblemExample.user
      val updatedUser = user
        .modify(_.generalInfo.siteInfo.userRating).using(_ + 1)
        .modify(_.billInfo.addresses.each.isConfirmed).using(_ => true)

      println(updatedUser.generalInfo.siteInfo.userRating)
      println(updatedUser.billInfo.addresses)
    }

    /**
     * It is also possible to create reusable lens as well as in scalaz.Lens
     */

    {
      import com.softwaremill.quicklens._
      val userRatingLens = modify(_:User)(_.generalInfo.siteInfo.userRating).using _
      val user = ProblemExample.user
      val updatedUser1 = userRatingLens(user)(_ + 10)
      val updatedUser2 = userRatingLens(user)(_ + 12)

      println(updatedUser1.generalInfo.siteInfo.userRating)
      println(updatedUser2.generalInfo.siteInfo.userRating)
    }

    /**
     * Of course lens composition is also possible.
     */

    {
      import com.softwaremill.quicklens._
      //create lens
      val generalInfoLens = modify(_:User)(_.generalInfo)
      val emailConfirmedLens = modify(_:GeneralInfo)(_.isEmailConfirmed)
      val phoneConfirmedLens = modify(_:GeneralInfo)(_.isPhoneConfirmed)

      //compose the lens
      val confirmEmail = generalInfoLens.andThenModify(emailConfirmedLens)(_:User).using(_ => true)
      val confirmPhone = generalInfoLens.andThenModify(phoneConfirmedLens)(_:User).using(_ => true)

      val user = ProblemExample.user
      //compose the functions in order to make both changes at once
      val updatedUser = confirmEmail.andThen(confirmPhone)(user)

      println(updatedUser.generalInfo.isEmailConfirmed)
      println(updatedUser.generalInfo.isPhoneConfirmed)
    }
  }
}
