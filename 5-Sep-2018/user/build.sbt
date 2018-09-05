
name := "user"

version := "0.1"

scalaVersion := "2.12.6"


val macwire = "com.softwaremill.macwire" %% "macros" % "2.3.0" % "provided"

lazy val `user` = (project in file("."))
  .aggregate(`user-api`, `user-impl`)

lazy val `user-api` = (project in file("user-api"))
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslApi
    )
  )

lagomCassandraEnabled in ThisBuild := false
lagomKafkaEnabled in ThisBuild := false
lazy val `user-impl` = (project in file("user-impl"))
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
  .dependsOn(`user-api`)