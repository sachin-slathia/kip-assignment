


package com.knoldus.serializers

import java.io.{ByteArrayInputStream, ObjectInputStream}
import java.util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.knoldus.streams.repository.Employee

import scala.reflect.classTag
//import com.typesafe.scalalogging.Logger
import org.apache.kafka.common.serialization.Deserializer

class EmployeeDeSerializer extends Deserializer[Employee] {


  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {
  }

  override def close(): Unit = {
  }

  //Receives data from stream and map it into Employee class
  val mapper = new ObjectMapper
  mapper.registerModule(DefaultScalaModule)

  override def deserialize(topic: String, data: Array[Byte]): Employee = data match {
    case null => null
    case _ =>
      try {
        mapper.readValue(data, classTag[Employee].runtimeClass.asInstanceOf[Class[Employee]])
      } catch {
        case e: Exception =>
          val jsonStr = new String(data, "UTF-8")
          print(s"Failed parsing ${jsonStr}", e)
          null
      }
  }


}
