lazy val root = (project in file(".")).
  settings(
    name := "koffio-lenses",
    version := "0.0.1",
    scalaVersion := "2.11.7"
  )

val monocleVersion = "1.2.0-M1"

libraryDependencies ++= Seq(
  "com.github.julien-truffaut"  %%  "monocle-core"    % monocleVersion,
  "com.github.julien-truffaut"  %%  "monocle-generic" % monocleVersion,
  "com.github.julien-truffaut"  %%  "monocle-macro"   % monocleVersion,
  "com.github.julien-truffaut"  %%  "monocle-state"   % monocleVersion,
  "com.github.julien-truffaut"  %%  "monocle-law"     % monocleVersion % "test",
  "com.github.pathikrit"        %% "sauron"           % "1.1.0",
  "com.softwaremill.quicklens"  %% "quicklens"        % "1.4.0",
  "org.scalaz"                  %% "scalaz-core"      % "7.1.3"
)

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0-M5" cross CrossVersion.full)