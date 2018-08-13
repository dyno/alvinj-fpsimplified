name := "alvinj-fpsimplified"
organization := "dynofu.me"
version := "0.1.0"

lazy val commonScalacOptions = Seq("-deprecation", "-feature", "-unchecked") //, "-Yno-imports")
lazy val commonSettings      = Seq(scalaVersion := "2.12.6", scalacOptions := commonScalacOptions)

lazy val AkkaRemoteActorsHelloWorld_HelloLocal  = (project in file("AkkaRemoteActorsHelloWorld/HelloLocal"))
lazy val AkkaRemoteActorsHelloWorld_HelloRemote = (project in file("AkkaRemoteActorsHelloWorld/HelloRemote"))
lazy val CoinFlipGameWithCatsIO                 = project
lazy val DebuggableInDetail                     = project
lazy val FPAkkaHelloWorld                       = project
lazy val FPCoinFlipGame                         = project
lazy val FPConcurrencyAndMutability             = project
lazy val FPDebuggable                           = project
lazy val FPFutures                              = project
lazy val FPIOMonadNotReallyUsed                 = project
lazy val FPLenses                               = project
lazy val FPModulesIrishSetter                   = project
lazy val FPMonadTransformers                    = project
lazy val FPRecursionIsGreatBut                  = project
lazy val FPScalaCheck                           = project
lazy val FPTypeClasses                          = project
lazy val FPTypeClassesWithCats                  = project
lazy val FpUpdateAsYouCopy                      = project
lazy val HandlingStateManually                  = project
lazy val IOMonad                                = project
lazy val IOMonadHelloWorld                      = project
lazy val PizzaPosFpModularStyle                 = project
lazy val PizzaPosOopStyle                       = project
lazy val RecursiveSum                           = project
lazy val StateMonadExample                      = project
lazy val TailRecursiveSum                       = project

lazy val subprojects = Seq(
    AkkaRemoteActorsHelloWorld_HelloLocal,
    AkkaRemoteActorsHelloWorld_HelloRemote,
    CoinFlipGameWithCatsIO,
    DebuggableInDetail,
    FPAkkaHelloWorld,
    FPCoinFlipGame,
    FPConcurrencyAndMutability,
    FPDebuggable,
    FPFutures,
    FPIOMonadNotReallyUsed,
    FPLenses,
    FPModulesIrishSetter,
    FPMonadTransformers,
    FPRecursionIsGreatBut,
    FPScalaCheck,
    FPTypeClasses,
    FPTypeClassesWithCats,
    FpUpdateAsYouCopy,
    HandlingStateManually,
    IOMonad,
    IOMonadHelloWorld,
    PizzaPosFpModularStyle,
    PizzaPosOopStyle,
    RecursiveSum,
    StateMonadExample,
    TailRecursiveSum
)

lazy val debugMsg = taskKey[Unit]("show debugMsg")
lazy val root = (project in file("."))
  .aggregate(subprojects.map(p => p: ProjectReference): _*)
  .dependsOn(subprojects.map(p => p: ClasspathDependency): _*)
  .settings(inThisBuild(commonSettings))
  .settings(debugMsg := {
    val out = streams.value // streams task happens before debugMsg
    val log = out.log
    log.info(subprojects.mkString("\n"))
  })

/**
  * Reference:
  *   https://www.scala-sbt.org/release/docs/Organizing-Build.html
  *
  *   https://www.scala-sbt.org/release/docs/Multi-Project.html
  * Default root project
  * If a project is not defined for the root directory in the build,
  * sbt creates a default one that aggregates all other projects in the build.
  *
  *   https://tpolecat.github.io/2017/04/25/scalac-flags.html
  *"-deprecation", // Emit warning and location for usages of deprecated APIs.
  *"-feature",     // Emit warning and location for usages of features that should be imported explicitly.
  *"-unchecked",   // Enable additional warnings where generated code depends on assumptions.
  *"-Yno-imports"  // no automatic imports at all; all symbols must be imported explicitly
  *
  *   https://www.scala-sbt.org/1.x/docs/Paths.html
  *
  *   https://www.scala-sbt.org/1.x/docs/Basic-Def.html
  *
  *   https://www.scala-sbt.org/1.x/docs/Task-Graph.html
  * inspired the sbt debug message.
  *
  *   https://stackoverflow.com/questions/51816943/is-it-possible-to-discover-subproject-module-in-build-sbt
  *   https://github.com/sbt/sbt/issues/2532, Ability to programmatically define projects: Seq[Project]
  *   https://stackoverflow.com/questions/30942220/sbt-dynamic-aggregation-of-subproject
  */
