package com.knoldus.cruise.impl

import akka.Done
import com.knoldus.cruise.api.models.GuestList
import com.lightbend.lagom.scaladsl.persistence.PersistentEntity.ReplyType
import play.api.libs.json.{Format, Json}

sealed trait CruiseCommand[R] extends ReplyType[R]

case class UseGreetingMessage(guestList: GuestList) extends CruiseCommand[Done]

object UseGreetingMessage {

  implicit val format: Format[UseGreetingMessage] = Json.format
}


case class Hello(guestList: GuestList) extends CruiseCommand[String]

object Hello {

  implicit val format: Format[Hello] = Json.format
}
