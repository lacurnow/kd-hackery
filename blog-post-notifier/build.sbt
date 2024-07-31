
import sbt.Keys.libraryDependencies


ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.14"

lazy val root = (project in file("."))
  .settings(
    name := "blog-post-notifier",
    libraryDependencies +=
      "org.scala-lang.modules" %% "scala-xml" % "2.3.0"
  )