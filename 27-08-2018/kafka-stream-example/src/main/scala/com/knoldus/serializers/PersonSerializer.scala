
package com.knoldus.serializers

import java.util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.knoldus.streams.repository.Person
import org.apache.kafka.common.serialization.Serializer


class PersonSerializer extends Serializer[Person] {

  val mapper = new ObjectMapper

  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {
  }

  mapper.registerModule(DefaultScalaModule)

  //Sends data to stream of Class Employee
  override def serialize(topic: String, obj: Person): Array[Byte] = {
    mapper.writeValueAsBytes(obj)
  }

  override def close(): Unit = {
  }

}

