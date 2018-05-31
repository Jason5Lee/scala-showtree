import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "org.jason5lee",
      scalaVersion := "2.12.6",
      version      := "1.0.0"
    )),
    name := "scala-showtree",
    libraryDependencies += scalaTest % Test
  )
