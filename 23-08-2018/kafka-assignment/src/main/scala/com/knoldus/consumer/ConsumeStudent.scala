package com.knoldus.consumer

import java.util

import com.knoldus.models.Student
import com.typesafe.scalalogging.Logger
import org.apache.kafka.clients.consumer.KafkaConsumer

import scala.collection.JavaConverters._

object ConsumerStudent extends App {

  import java.util.Properties

  val server = "studentData"

  val log = Logger("print")
  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("group.id", "test")
  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "com.knoldus.serializers.CustomDeSerializer")
  val consumer = new KafkaConsumer[String, Student](props)

  consumer.subscribe(util.Collections.singletonList(server))


  while (true) {
    val records = consumer.poll(100)
    for (record <- records.asScala) {
      log.info(s"record key = ${record.key()} record Value = ${record.value()} ")
    }
  }
  consumer.close()
}