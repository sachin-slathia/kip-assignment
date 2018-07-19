package com.knoldus

import org.scalatest.{FunSuite, Matchers}


class InputDeciderSpec extends FunSuite with Matchers {


  val testAcceptor1 = new InputDecider

  test("Finding return type when we are passing String object") {
    val actualResult = testAcceptor1.matchInput("Sachin")
    val expectedResult = "you have given me a String Sachin"
    actualResult should equal(expectedResult)
  }
  test("Finding return type when we are passing int object") {
    val actualResult = testAcceptor1.matchInput(15)
    val expectedResult = "thanks for giving Int 15"
    actualResult should equal(expectedResult)
  }

  test("Finding return type when we are passing Float object") {
    val actualResult = testAcceptor1.matchInput(15.5f)
    val expectedResult = "thanks for giving float 15.5"
    actualResult should equal(expectedResult)
  }
  test("Finding return type when we are passing Array[Int] object") {
    val actualResult = testAcceptor1.matchInput(Array(1, 2, 3, 4))
    val expectedResult = "you have entered Array[Int]"
    actualResult should equal(expectedResult)
  }
  test("Finding return type when we are passing Array[String] object") {
    val actualResult = testAcceptor1.matchInput(Array("1", "2", "3", "4"))
    val expectedResult = "you have given me a Array[String]"
    actualResult should equal(expectedResult)
  }
  test("Finding return type when we are passing List[Any] object") {
    val actualResult = testAcceptor1.matchInput(List("1", "2", "3", "4", 99))
    val expectedResult = "thanks for giving a List[Any]"
    actualResult should equal(expectedResult)
  }
  test("Finding return type when we are passing case class Pet object") {
    val actualResult = testAcceptor1.matchInput(Pet("Rocky"))
    val expectedResult = "thanks for giving name of your pet"
    actualResult should equal(expectedResult)
  }
  test("Finding return type when we are passing Map object") {
    val actualResult = testAcceptor1.matchInput(Map("Salary" -> 15000))
    val expectedResult = "you have entered Map[ , ]"
    actualResult should equal(expectedResult)
  }
  test("Finding return type when we are passing Set object") {
    val actualResult = testAcceptor1.matchInput(Set(15000))
    val expectedResult = "Sorry not in our application please pass another value"
    actualResult should equal(expectedResult)
  }

}
