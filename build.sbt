name := "alvinj-fpsimplified"

lazy val commonSettings =
  Seq(organization := "Whatever", version := "0.1.0", scalaVersion := "2.12.6")

lazy val AkkaRemoteActorsHelloWorld_HelloLocal = (project in file(
    "AkkaRemoteActorsHelloWorld/HelloLocal"))
lazy val AkkaRemoteActorsHelloWorld_HelloRemote = (project in file(
    "AkkaRemoteActorsHelloWorld/HelloRemote"))
lazy val CoinFlipGameWithCatsIO     = project
lazy val DebuggableInDetail         = project
lazy val FPAkkaHelloWorld           = project
lazy val FPCoinFlipGame             = project
lazy val FPConcurrencyAndMutability = project
lazy val FPDebuggable               = project
lazy val FPFutures                  = project
lazy val FPIOMonadNotReallyUsed     = project
lazy val FPLenses                   = project
lazy val FPModulesIrishSetter       = project
lazy val FPMonadTransformers        = project
lazy val FPRecursionIsGreatBut      = project
lazy val FPScalaCheck               = project
lazy val FPTypeClasses              = project
lazy val FPTypeClassesWithCats      = project
lazy val FpUpdateAsYouCopy          = project
lazy val HandlingStateManually      = project
lazy val IOMonad                    = project
lazy val IOMonadHelloWorld          = project
lazy val PizzaPosFpModularStyle     = project
lazy val PizzaPosOopStyle           = project
lazy val RecursiveSum               = project
lazy val StateMonadExample          = project
lazy val TailRecursiveSum           = project

/**
  * Reference:
  *   https://www.scala-sbt.org/release/docs/Organizing-Build.html
  *
  *   https://www.scala-sbt.org/release/docs/Multi-Project.html
  * Default root project
  * If a project is not defined for the root directory in the build,
  * sbt creates a default one that aggregates all other projects in the build.
  */
