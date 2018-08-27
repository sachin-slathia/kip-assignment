package com.knoldus.serdes


import java.util

import com.knoldus.serializers.{PersonDeserializer, PersonSerializer}
import com.knoldus.streams.repository.Person
import org.apache.kafka.common.serialization.{Deserializer, Serde, Serializer}


class PersonSerde extends Serde[Person] {


  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {

  }

  override def close(): Unit = {

  }

  override def serializer(): Serializer[Person] = new PersonSerializer

  override def deserializer(): Deserializer[Person] = new PersonDeserializer
}


