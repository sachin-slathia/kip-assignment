

package com.knoldus.serializers

import java.io.{ByteArrayInputStream, ObjectInputStream}
import java.util

import com.knoldus.streams.repository.Employee
//import com.typesafe.scalalogging.Logger
import org.apache.kafka.common.serialization.Deserializer

class CustomDeSerializer extends Deserializer[Employee] {


  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {
  }

  override def close(): Unit = {
  }

  //Receives data from stream and map it into Student class
  override def deserialize(topic: String, bytes: Array[Byte]): Employee = {

    // val log = Logger("print")
    try {
      if (bytes == null)
        print("No value is present in class Student")
      val byteInputStream = new ByteArrayInputStream(bytes)
      val inputObject = new ObjectInputStream(byteInputStream)
      val objectDeserialized = inputObject.readObject().asInstanceOf[Employee]
      objectDeserialized
    }
    catch {

      case ex: Exception => throw new Exception(ex.getMessage)
    }
  }

}
