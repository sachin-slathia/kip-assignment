package com.knoldus.consumer.producer

import com.knoldus.models.Student


object ConsumeProducer extends App {

  import java.util.Properties

  import org.apache.kafka.clients.producer._


  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "com.knoldus.serializers.CustomSerializer")

  val producer = new KafkaProducer[String, Student](props)

  val server = "studentData"

  for (i <- 1 to 20) {
    producer.send(new ProducerRecord[String, Student](server, i.toString,
      Student(i, s"Sachin$i")))

  }


  producer.close()
}


