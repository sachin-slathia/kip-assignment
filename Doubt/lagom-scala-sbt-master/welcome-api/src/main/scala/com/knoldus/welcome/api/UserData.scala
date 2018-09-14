//package com.knoldus.welcome.api
//
//import play.api.libs.json.{Format, Json}
//
//case class UserData(userId: Int, id: Int, title:String, body: String)
//
//case class Guests()
//
//case class GuestInformation(guestReservationId: GuestReservationId,personalInfo: PersonalInfo,contactInfo: ContactInfo,
//                            travelPhoto: TravelPhoto,emergencyContactInfo: EmergencyContactInfo,insuranceInfo: InsuranceInfo,
//                            immigrationInfo: ImmigrationInfo)
//
//case class GuestReservationId(guestId:String,bookingId:String)
//
//case class PersonalInfo(guestTitle:String,firstName:String, middleName:String,middleNameFlag:String,lastName:String,
//                        suffix:String,birthDate:String,gender:String,maritalStatus:String,localeFirstName:String,
//                        localeMiddleName:String,localeLastName:String,loyaltyNumber:String,occupation:String)
//
//case class ContactInfo(phoneNumber:String,residence:String,mobile:String,business:String)
//
//case class TravelPhoto(base64Image:String,photoId:String)
//
//case class EmergencyContactInfo(firstName:String,lastName:String,phoneNumber:String,email:String)
//
//case class InsuranceInfo(name:String,phoneNumber:String,policyNumber:String)
//
//case class ImmigrationInfo()
//
//case class Documents(typeOf:String,number:String,expiryDate:String,issuingDate:String,
//                     issuingCity:String,countryCode:String,issuingState:String,firstName:String,lastName:String,birthDate:String)
//
//case class MachineReadableTravelDocument(firstName:String,lastName:String,documentNumber:String)
//
//case class CruiseSurvey(heardFrom:String,cruiseCountWithUs:String,cruiseCount:String,cruisedWithUsBefore:String)
//
//object UserData {
//
//  implicit val format: Format[UserData] = Json.format[UserData]
//}
