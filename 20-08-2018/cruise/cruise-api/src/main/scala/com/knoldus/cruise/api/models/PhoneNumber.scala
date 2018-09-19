package com.knoldus.cruise.api.models

import play.api.libs.json.{Format, Json}

case class PhoneNumber(residence: String, mobile: String, business: String)
object PhoneNumber{

  implicit val format: Format[PhoneNumber] = Json.format[PhoneNumber]
}
