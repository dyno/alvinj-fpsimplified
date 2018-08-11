name := "IOMonadHelloWorld"

version := "0.1"

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
    "org.typelevel" %% "cats" % "0.9.0",
    "org.typelevel" %% "cats-effect" % "0.3"
)

scalacOptions += "-deprecation"


