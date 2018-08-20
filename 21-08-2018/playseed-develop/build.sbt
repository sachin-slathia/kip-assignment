name := """Assignment"""
organization := "knoldus"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.11"

javaOptions in Test += "-Dconfig.file=conf/test.conf"

libraryDependencies ++= Seq (
  guice,
  ehcache
)




// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
