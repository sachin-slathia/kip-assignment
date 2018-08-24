name := "kafka-assignment"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(  "org.apache.kafka" %% "kafka" % "1.1.0",

                              "org.apache.kafka" % "kafka-clients" % "0.11.0.0",

                              "log4j" % "log4j" % "1.2.17",
  
                                "org.slf4j" % "slf4j-simple" % "1.7.25")
