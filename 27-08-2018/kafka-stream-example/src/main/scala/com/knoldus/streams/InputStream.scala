package streams

import java.util.Properties

import com.knoldus.streams.repository.{Employee, Person}
import com.knoldus.streams.serdes.CustomSerde
import org.apache.kafka.common.serialization._
import org.apache.kafka.streams.kstream.{KStream, KStreamBuilder}
import org.apache.kafka.streams.{KafkaStreams, StreamsConfig}


object MapExample extends App {

  val config = {
    val properties = new Properties()
    properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "stream-application-v9")
    properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
    properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass)
    properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, classOf[CustomSerde])


    properties
  }


  val builder = new KStreamBuilder()
  val originalStream: KStream[String, Employee] = builder.
    stream("test-sqlite-jdbc-Employee")
  print(originalStream.print())


  val modifiedStream: KStream[String, Person] = originalStream.mapValues(employee => Person(employee.id,
    if (employee.gender.equalsIgnoreCase("MAle")) s"Mr ${employee.firstName} " +
      s"${employee.lastName}" else s"Miss ${employee.firstName} ${employee.lastName}"))



  val str = new KafkaStreams(builder, config)
  str.cleanUp()
  str.start()

  modifiedStream.to("Person")


}