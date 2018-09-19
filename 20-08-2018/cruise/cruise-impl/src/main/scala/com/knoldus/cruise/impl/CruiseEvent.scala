package com.knoldus.cruise.impl

import com.knoldus.cruise.api.models.GuestList
import com.lightbend.lagom.scaladsl.persistence.{AggregateEvent, AggregateEventTag}
import play.api.libs.json.{Format, Json}

sealed trait CruiseEvent extends AggregateEvent[CruiseEvent] {
  def aggregateTag = CruiseEvent.Tag
}

object CruiseEvent {
  val Tag = AggregateEventTag[CruiseEvent]
}

case class GreetingMessageChanged(guestList: GuestList) extends CruiseEvent

object GreetingMessageChanged {

  implicit val format: Format[GreetingMessageChanged] = Json.format
}
