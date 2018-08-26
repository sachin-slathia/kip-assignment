

package com.knoldus.serializers


import java.io.{ByteArrayOutputStream, ObjectOutputStream}
import java.util

import com.knoldus.streams.repository.Employee
import org.apache.kafka.common.serialization.Serializer

class CustomSerializer extends Serializer[Employee] {

  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {
  }


  //Sends data to stream of Class Employee
  override def serialize(topic: String, data: Employee): Array[Byte] = {

    try {
      val byteOutputStream = new ByteArrayOutputStream()
      val objectSerialized = new ObjectOutputStream(byteOutputStream)
      objectSerialized.writeObject(data)
      byteOutputStream.toByteArray
    }
    catch {
      case ex: Exception => throw new Exception(ex.getMessage)
    }
  }

  override def close(): Unit = {
  }

}
