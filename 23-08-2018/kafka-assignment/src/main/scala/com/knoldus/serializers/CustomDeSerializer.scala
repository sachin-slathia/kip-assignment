package com.knoldus.serializers

import java.io.{ByteArrayInputStream, ObjectInputStream}
import java.util

import com.knoldus.models.Student
import com.typesafe.scalalogging.Logger
import org.apache.kafka.common.serialization.Deserializer

class CustomDeSerializer extends Deserializer[Student] {


  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {
  }

  override def close(): Unit = {
  }

  //Receives data from stream and map it into Student class
  override def deserialize(topic: String, bytes: Array[Byte]): Student = {

    val log = Logger("print")
    try {
      if (bytes == null)
        log.info("No value is present in class Student")
      val byteInputStream = new ByteArrayInputStream(bytes)
      val inputObject = new ObjectInputStream(byteInputStream)
      val objectDeserialized = inputObject.readObject().asInstanceOf[Student]
      objectDeserialized
    }
    catch {
      case ex: Exception => throw new Exception(ex.getMessage)
    }
  }

}
