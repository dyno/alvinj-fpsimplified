name := "koffio-lenses"
version := "0.0.1"

import Dependencies.{paradise, lensDeps}
libraryDependencies ++= lensDeps

addCompilerPlugin(paradise cross CrossVersion.full)
