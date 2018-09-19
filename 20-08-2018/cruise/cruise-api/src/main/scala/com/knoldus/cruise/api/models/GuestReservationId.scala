package com.knoldus.cruise.api.models

import play.api.libs.json.{Format, Json}

case class GuestReservationId(guestId: String, bookingId: String)

object GuestReservationId{

  implicit val format: Format[GuestReservationId] = Json.format[GuestReservationId]
}
