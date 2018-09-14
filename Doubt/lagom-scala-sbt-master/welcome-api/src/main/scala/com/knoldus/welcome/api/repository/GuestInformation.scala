package com.knoldus.welcome.api.repository

import play.api.libs.json.{Format, Json}

case class GuestInformation(guestReservationId: GuestReservationId, personalInfo: PersonalInfo, contactInfo: ContactInfo,
                            travelPhoto: TravelPhoto, emergencyContactInfo: EmergencyContactInfo, insuranceInfo: InsuranceInfo,
                            immigrationInfo: ImmigrationInfo)

object GuestInformation {

  implicit val format: Format[GuestInformation] = Json.format[GuestInformation]
}
