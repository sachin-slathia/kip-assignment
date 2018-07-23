package com.knoldus
import org.scalatest.{FunSuite, MustMatchers}

class EmailParsingSpec  extends FunSuite with MustMatchers {

  val test = new EmailParsing
  test("Testing for a valid email"){
    val actualResult = test.emailParser("slathiasachin13@gmail.com")
    val expectedResult = "User slathiasachin13 Domain gmail.com"

    actualResult must equal(expectedResult)
  }
  test("Testing for a invalid email which is missing a @"){
    val actualResult = test.emailParser("slathiasachin13gmail.com")
    val expectedResult = "Not a valid email"

    actualResult must equal(expectedResult)
  }
  test("Testing for a invalid email which is missing a ."){
    val actualResult = test.emailParser("slathiasachin13@gmailcom")
    val expectedResult = "Not a valid email"

    actualResult must equal(expectedResult)
  }

}


