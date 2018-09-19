
name := "cruise"

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.4"

val macwire = "com.softwaremill.macwire" %% "macros" % "2.3.0" % "provided"

lazy val `cruise` = (project in file("."))
  .aggregate(`cruise-api`, `cruise-impl`)

lazy val `cruise-api` = (project in file("cruise-api"))
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslApi
    )
  )

lazy val `cruise-impl` = (project in file("cruise-impl"))
  .enablePlugins(LagomScala)
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslPersistenceCassandra,
      lagomScaladslKafkaBroker,
      lagomScaladslTestKit,
      macwire
    )
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`cruise-api`)

//Define the external service’s host and port name.
lagomUnmanagedServices in ThisBuild := Map("external-service" -> "https://gist.githubusercontent.com")