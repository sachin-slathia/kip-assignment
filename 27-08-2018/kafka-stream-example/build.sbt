name := "kafka-stream-example"

version := "0.1"

scalaVersion := "2.12.6"
// https://mvnrepository.com/artifact/org.apache.kafka/kafka-streams
libraryDependencies += "org.apache.kafka" % "kafka-streams" % "1.1.0"
// https://mvnrepository.com/artifact/org.apache.avro/avro-maven-plugin
libraryDependencies += "org.apache.avro" % "avro-maven-plugin" % "1.8.2"

// https://mvnrepository.com/artifact/net.sf.jason/jason
libraryDependencies += "net.sf.jason" % "jason" % "1.4.2"
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.6"


