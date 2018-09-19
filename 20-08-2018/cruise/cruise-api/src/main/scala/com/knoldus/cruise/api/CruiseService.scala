package com.knoldus.cruise.api

import akka.{Done, NotUsed}
import com.knoldus.cruise.api.models.GuestList
import com.lightbend.lagom.scaladsl.api.broker.Topic
import com.lightbend.lagom.scaladsl.api.transport.Method
import com.lightbend.lagom.scaladsl.api.{Service, ServiceCall}
import play.api.libs.json.{Format, Json}


trait CruiseService extends Service {

  override final def descriptor = {
    import Service._
    // @formatter:off
    named("welcome")
      .withCalls(
        pathCall("/consume/guest", consumeGuest _)
        ,pathCall("/use/:id", useGreeting _)
      )
      .withTopics(
        topic(CruiseService.TOPIC_NAME, greetingsTopic)
      )
      .withAutoAcl(true)
    // @formatter:on
  }

  def consumeGuest(): ServiceCall[NotUsed, GuestList]

  def greetingsTopic(): Topic[GreetingMessageChanged]

  def useGreeting(id: String): ServiceCall[GreetingMessage, Done]
}

case class GreetingMessage(message: GuestList)

object GreetingMessage {

  implicit val format: Format[GreetingMessage] = Json.format[GreetingMessage]
}

case class GreetingMessageChanged(message: GuestList)

object GreetingMessageChanged {

  implicit val format: Format[GreetingMessageChanged] = Json.format[GreetingMessageChanged]
}

object CruiseService {
  val TOPIC_NAME = "information"
}
