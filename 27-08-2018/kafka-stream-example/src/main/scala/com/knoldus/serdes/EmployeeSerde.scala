

package com.knoldus.streams.serdes

import java.util

import com.knoldus.serializers.{EmployeeDeSerializer, EmployeeSerializer}
import com.knoldus.streams.repository.Employee
import org.apache.kafka.common.serialization.{Deserializer, Serde, Serializer}


class EmployeeSerde extends Serde[Employee] {


  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {

  }

  override def close(): Unit = {

  }

  override def serializer(): Serializer[Employee] = new EmployeeSerializer

  override def deserializer(): Deserializer[Employee] = new EmployeeDeSerializer
}


