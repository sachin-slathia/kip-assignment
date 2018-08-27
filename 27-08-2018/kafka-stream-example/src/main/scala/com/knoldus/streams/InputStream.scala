
package streams

import java.util.Properties

import com.knoldus.serializers.{PersonDeserializer, PersonSerializer}
import com.knoldus.streams.repository.{Employee, Person}
import com.knoldus.streams.serdes.EmployeeSerde
import org.apache.kafka.common.serialization._
import org.apache.kafka.streams.kstream.{KStream, KStreamBuilder, Produced}
import org.apache.kafka.streams.{KafkaStreams, KeyValue, StreamsConfig}


object MapExample extends App {

  val config = {
    val properties = new Properties()
    properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "stream-application-v10")
    properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
    properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass)
    properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, classOf[EmployeeSerde])


    properties
  }


  val builder = new KStreamBuilder()
  val originalStream: KStream[String, Employee] = builder.
    stream("test-sqlite-jdbc-Employee")
  print(originalStream.print())


  val updatedStream: KStream[String, Person] = originalStream.map((key, employee: Employee) => {

    val person = Person(employee.Id,
      if (employee.GENDER.equalsIgnoreCase("MAle")) s"Mr ${employee.FIRST_NAME} " +
        s"${employee.LAST_NAME}" else s"Miss ${employee.FIRST_NAME} ${employee.LAST_NAME}")

    KeyValue.pair(key, person)

  })

  print(updatedStream.print())

  val personSerde: Serde[Person] = Serdes.serdeFrom(new PersonSerializer, new PersonDeserializer)

  updatedStream.to("Person1", Produced.`with`(Serdes.String(), personSerde))
  val str = new KafkaStreams(builder, config)
  str.cleanUp()
  str.start()





}


