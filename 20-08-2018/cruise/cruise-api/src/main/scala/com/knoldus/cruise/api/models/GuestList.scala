package com.knoldus.cruise.api.models

import play.api.libs.json.{Format, Json}

case class GuestList(guests: List[Guests])


object GuestList{

  implicit val format: Format[GuestList] = Json.format[GuestList]
}




