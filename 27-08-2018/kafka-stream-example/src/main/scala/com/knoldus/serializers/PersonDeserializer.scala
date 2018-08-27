
package com.knoldus.serializers

import java.util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.knoldus.streams.repository.Person
import org.apache.kafka.common.serialization.Deserializer

import scala.reflect.classTag


class PersonDeserializer extends Deserializer[Person] {


  //Receives data from stream and map it into Employee class
  val mapper = new ObjectMapper

  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {
  }

  override def close(): Unit = {
  }
  mapper.registerModule(DefaultScalaModule)

  override def deserialize(topic: String, data: Array[Byte]): Person = data match {
    case null => null
    case _ =>
      try {
        mapper.readValue(data, classTag[Person].runtimeClass.asInstanceOf[Class[Person]])
      } catch {
        case e: Exception =>
          val jsonStr = new String(data, "UTF-8")
          print(s"Failed parsing ${jsonStr}", e)
          null
      }
  }


}