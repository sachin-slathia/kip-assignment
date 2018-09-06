package com.knoldus.welcome.api.repository

import play.api.libs.json.{Format, Json}

case class EmergencyContactInfo(firstName: String, lastName: String,
                                phoneNumber: String, email: String)

object EmergencyContactInfo{

  implicit val format: Format[EmergencyContactInfo] = Json.format[EmergencyContactInfo]
}
