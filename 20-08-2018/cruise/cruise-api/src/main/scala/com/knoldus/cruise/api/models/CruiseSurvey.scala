package com.knoldus.cruise.api.models

import play.api.libs.json.{Format, Json}

case class CruiseSurvey(heardFrom: String, cruiseCountWithUs: String, cruiseCount: String,
                         cruisedWithUsBefore: String)

object CruiseSurvey{

  implicit val format: Format[CruiseSurvey] = Json.format[CruiseSurvey]
}
