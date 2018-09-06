package com.knoldus.welcome.api.repository

import play.api.libs.json.{Format, Json}

case class JsonObject(guests: List[Guests])

object JsonObject{

  implicit val format: Format[JsonObject] = Json.format[JsonObject]
}
