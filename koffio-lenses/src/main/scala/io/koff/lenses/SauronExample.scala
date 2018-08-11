package io.koff.lenses

import io.koff.model.{GeneralInfo, User, ProblemExample}

/**
 * Example of usage of sauron lens
 */
object SauronExample {
  def main(args: Array[String]) {
    /**
     * As it is said on the main page of `Sauron` repo it has been inspired by `quicklens`
     * but it has much simpler implementation and less number of features.
     * And also has additional dependency on `"org.scalamacros" % "paradise" % "2.1.0-M5"`
     */

    /**
     * So lets see what exactly `sauron` can do
     */
    /**
     * Change value of userRating
     */
    {
      import com.github.pathikrit.sauron._

      val user = ProblemExample.user
      val updatedUser = lens(user)(_.generalInfo.siteInfo.userRating)(_ + 10)

      println(updatedUser.generalInfo.siteInfo.userRating)
    }

    /**
     * Reusing lens to change a specific object
     */
    {
      import com.github.pathikrit.sauron._
      val user = ProblemExample.user
      val userRatingLens = lens(user)(_.generalInfo.siteInfo.userRating)
      val userWith20Rating = userRatingLens(_ => 20)
      val userWith100Rating = userRatingLens( _ + 100 )

      println(userWith20Rating.generalInfo.siteInfo.userRating)
      println(userWith100Rating.generalInfo.siteInfo.userRating)
    }

    /**
     * Define lens to change different objects
     */
    {
      import com.github.pathikrit.sauron._

      val userRatingLens = lens(_:User)(_.generalInfo.siteInfo.userRating)

      val user = ProblemExample.user

      val userWith20Rating = userRatingLens(user)(_ => 20)
      val userWith100Rating = userRatingLens(user)( _ + 100 )

      println(userWith20Rating.generalInfo.siteInfo.userRating)
      println(userWith100Rating.generalInfo.siteInfo.userRating)
    }

    /**
     * Also `sauron` has lens composition
     */
    {
      import com.github.pathikrit.sauron._
      val generalInfoLens = lens(_:User)(_.generalInfo)
      val emailConfirmedLens = lens(_:GeneralInfo)(_.isEmailConfirmed)
      val phoneConfirmedLens = lens(_:GeneralInfo)(_.isPhoneConfirmed)

      val user = ProblemExample.user
      val confirmEmail = generalInfoLens.andThenLens(emailConfirmedLens)(_:User)(_ => true)
      val confirmPhone = generalInfoLens.andThenLens(phoneConfirmedLens)(_:User)(_ => true)

      //compose the functions in order to make both changes at once
      val updatedUser = confirmEmail.andThen(confirmPhone)(user)

      println(updatedUser.generalInfo.isEmailConfirmed)
      println(updatedUser.generalInfo.isPhoneConfirmed)
    }

    /**
     * You can see that the example above is quite similar to `quicklens` example of lens composition
     */
  }
}
