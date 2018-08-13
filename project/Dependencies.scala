import sbt._

object Dependencies {
  // Versions
  lazy val akkaVersion                   = "2.5.14"    // https://akka.io/docs/
  lazy val apacheCommonsLangVersion      = "3.7"       // https://commons.apache.org/
  lazy val apacheHttpClientVersion       = "4.5.6"     // http://hc.apache.org/news.html
  lazy val catsCoreVersion               = "1.2.0"     // https://typelevel.org/cats/
  lazy val catsEffectVersion             = "1.0.0-RC2" // https://github.com/typelevel/cats-effect
  lazy val finagleVersion                = "18.8.0"    // https://twitter.github.io/finagle/guide/Quickstart.html
  lazy val monocleVersion                = "1.5.0"     // http://julien-truffaut.github.io/Monocle/
  lazy val quicklensVersion              = "1.4.11"    // https://github.com/adamw/quicklens
  lazy val scalaCheckVersion             = "1.14.0"    // https://www.scalacheck.org/
  lazy val scalaParserCombinatorsVersion = "1.1.1"     // https://github.com/scala/scala-parser-combinators
  lazy val scalaTestVersion              = "3.0.5"     // http://www.scalatest.org/
  lazy val scalacticVersion              = "3.0.5"     // http://www.scalactic.org/
  lazy val scalazVersion                 = "7.2.25"    // https://github.com/scalaz/scalaz
  lazy val specs2Version                 = "0.5.2"     // https://github.com/typelevel/scalaz-specs2

  // Libraries
  val akkaActor               = "com.typesafe.akka"          %% "akka-actor"                % akkaVersion
  val akkaRemote              = "com.typesafe.akka"          %% "akka-remote"               % akkaVersion
  val akkaTestKit             = "com.typesafe.akka"          %% "akka-testkit"              % akkaVersion % Test
  val apacheCommonsLang       = "org.apache.commons"         % "commons-lang3"              % apacheCommonsLangVersion
  val apacheHttpClient        = "org.apache.httpcomponents"  % "httpclient"                 % apacheHttpClientVersion
  val catsCore                = "org.typelevel"              %% "cats-core"                 % catsCoreVersion
  val catsEffect              = "org.typelevel"              %% "cats-effect"               % catsEffectVersion
  val finagleHttp             = "com.twitter"                %% "finagle-http"              % finagleVersion
  val finagleUtilCollection   = "com.twitter"                %% "util-collection"           % finagleVersion
  val monocleCore             = "com.github.julien-truffaut" %% "monocle-core"              % monocleVersion
  val monocleGeneric          = "com.github.julien-truffaut" %% "monocle-generic"           % monocleVersion
  val monocleLaw              = "com.github.julien-truffaut" %% "monocle-law"               % monocleVersion % "test"
  val monocleMacro            = "com.github.julien-truffaut" %% "monocle-macro"             % monocleVersion
  val monocleState            = "com.github.julien-truffaut" %% "monocle-state"             % monocleVersion
  val quicklens               = "com.softwaremill.quicklens" %% "quicklens"                 % quicklensVersion
  val scalaCheck              = "org.scalacheck"             %% "scalacheck"                % scalaCheckVersion % "test"
  val scalaParserCombinators  = "org.scala-lang.modules"     %% "scala-parser-combinators"  % scalaParserCombinatorsVersion
  val scalaTest               = "org.scalatest"              %% "scalatest"                 % scalaTestVersion % "test"
  val scalactic               = "org.scalactic"              %% "scalactic"                 % scalacticVersion % "test"
  val scalazConcurrent        = "org.scalaz"                 %% "scalaz-concurrent"         % scalazVersion
  val scalazCore              = "org.scalaz"                 %% "scalaz-core"               % scalazVersion
  val scalazScalaCheckBinding = "org.scalaz"                 %% "scalaz-scalacheck-binding" % scalazVersion % "test"
  val scalazSpecs2            = "org.typelevel"              %% "scalaz-specs2"             % specs2Version % "test"

  // Dependency group
  val akkaDeps   = Seq(akkaActor, akkaRemote, akkaTestKit)
  val scalazDeps = Seq(scalazCore, scalazConcurrent, scalazScalaCheckBinding, scalazSpecs2)

}

/**
  * Reference:
  *   https://stackoverflow.com/questions/17461453/build-scala-and-symbols-meaning
  *   https://www.scala-sbt.org/1.x/docs/Library-Dependencies.html
  */
