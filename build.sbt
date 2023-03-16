ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "practice-5",
    idePackagePrefix := Some("ru.tinkoff.practice5")
  )
