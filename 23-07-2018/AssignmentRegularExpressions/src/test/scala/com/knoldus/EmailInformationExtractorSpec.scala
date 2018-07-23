package com.knoldus

import org.scalatest.{FunSuite, Matchers}

class EmailInformationExtractorSpec extends FunSuite with Matchers {

  val url = new EmailInformationExtractor

  test("Asking user to write amazon web services") {

    val actualResult = url.URL.apply("aws.amazon.com")
    val expectedResult = "https://aws.amazon.com/console/home?state=hash&isauthcode=true&code=112"
    actualResult should equal(expectedResult)
  }


  test("Extracting information from link") {

    val actualResult = url.URL.unapply("https://aws.amazon.com/console/home?state=hash&isauthcode=true&code=112")
    val expectedResult = Some("https", "aws.amazon.com", "console/home", Map("state" -> "hash", "isauthcode" -> "true", "code" -> "112"))
    actualResult should equal(expectedResult)
  }
  test("Extracting information from blank String") {

    assertThrows[Exception](url.URL.unapply(""))
  }


}
