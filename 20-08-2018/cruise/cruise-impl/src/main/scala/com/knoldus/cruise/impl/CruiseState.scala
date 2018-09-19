package com.knoldus.cruise.impl

import com.knoldus.cruise.api.models.GuestList
import play.api.libs.json.{Format, Json}


case class CruiseState(name:String,guestList: GuestList, timestamp: String)

object CruiseState {

  implicit val format: Format[CruiseState] = Json.format
}
