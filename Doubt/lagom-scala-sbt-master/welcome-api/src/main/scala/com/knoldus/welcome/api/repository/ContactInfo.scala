package com.knoldus.welcome.api.repository

import play.api.libs.json.{Format, Json}

case class ContactInfo(phoneNumber: PhoneNumber,
                        email: String,
                        alternateEmail: String,
                        faxNumber: String,
                        prefferedContactMethod: String
                      )
object ContactInfo{

  implicit val format: Format[ContactInfo] = Json.format[ContactInfo]
}

