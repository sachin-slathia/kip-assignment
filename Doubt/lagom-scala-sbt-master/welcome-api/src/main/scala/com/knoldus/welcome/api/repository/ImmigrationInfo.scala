package com.knoldus.welcome.api.repository

import play.api.libs.json.{Format, Json}

case class ImmigrationInfo(machineReadableTravelDocument: MachineReadableTravelDocument, countryOfBirth: String,
                            countryOfCitizenship: String, documents: List[Documents])

object ImmigrationInfo{

  implicit val format: Format[ImmigrationInfo] = Json.format[ImmigrationInfo]
}
