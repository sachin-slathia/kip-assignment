
name := "cruise"

version := "0.1"

scalaVersion := "2.12.6"

val macwire = "com.softwaremill.macwire" %% "macros" % "2.3.0" % "provided"

lazy val `cruise` = (project in file("."))
  .aggregate(`cruise-api`, `cruise-impl`)

lazy val `cruise-api` = (project in file("cruise-api"))
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslApi
    )
  )

lagomCassandraEnabled in ThisBuild := false
lagomKafkaEnabled in ThisBuild := false
lazy val `cruise-impl` = (project in file("cruise-impl"))
  .enablePlugins(LagomScala)
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslPersistenceCassandra,
      lagomScaladslKafkaBroker,
      lagomScaladslTestKit,
      macwire,
    )
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`cruise-api`)

//Define the external service’s host and port name.
lagomUnmanagedServices in ThisBuild := Map("external-service" -> "https://gist.githubusercontent.com")