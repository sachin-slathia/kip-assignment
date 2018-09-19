package com.knoldus.cruise.api.models

import play.api.libs.json.{Format, Json}

case class Guests(guestInformation: GuestInformation, invalidateCTCForMinor: String)

object Guests {

  implicit val format: Format[Guests] = Json.format[Guests]
}
