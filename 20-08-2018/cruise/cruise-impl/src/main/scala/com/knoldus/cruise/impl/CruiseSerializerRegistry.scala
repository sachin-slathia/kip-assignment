package com.knoldus.cruise.impl

import com.lightbend.lagom.scaladsl.playjson.{JsonSerializer, JsonSerializerRegistry}

import scala.collection.immutable.Seq

object CruiseSerializerRegistry extends JsonSerializerRegistry {
  override def serializers: Seq[JsonSerializer[_]] = Seq(
    JsonSerializer[UseGreetingMessage],
    JsonSerializer[Hello],
    JsonSerializer[GreetingMessageChanged],
    JsonSerializer[CruiseState]
  )
}