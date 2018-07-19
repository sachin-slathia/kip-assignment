package com.knoldus

import org.scalatest.{FunSuite, Matchers}

class FindOperationsSpec extends FunSuite with Matchers {


  val testAcceptor1 = new FindOperations

  test("Finding maximum element in positive element list") {
    val actualResult = testAcceptor1.maximumElement(List(1, 2, 12, 231, 13, 5645, 0))
    val expectedResult = 5645
    actualResult should equal(expectedResult)
  }
  test("Finding maximum element in negative element list") {
    val actualResult = testAcceptor1.maximumElement(List(-16, -2, -565, -77, -34))
    val expectedResult = -2
    actualResult should equal(expectedResult)
  }
  test("Finding maximum element in positive and negative element list") {
    val actualResult = testAcceptor1.maximumElement(List(-16, -2, -565, -77, -34, 1, 2, 12, 231, 13, 56, 0))
    val expectedResult = 231
    actualResult should equal(expectedResult)
  }
  test("Finding minimum element in positive and negative element list") {
    val actualResult = testAcceptor1.minimumElement(List(-16, -20, -565, -77, -34, 1, 2, 12, 231, 13, 56))
    val expectedResult = -565
    actualResult should equal(expectedResult)
  }
  test("Finding minimum element in negative element list") {
    val actualResult = testAcceptor1.minimumElement(List(-16, -2, -565, -77, -34))
    val expectedResult = -565
    actualResult should equal(expectedResult)
  }
  test("Finding minimum element in positive element list") {
    val actualResult = testAcceptor1.minimumElement(List(100, 20, 12, 231, 13, 5645))
    val expectedResult = 12
    actualResult should equal(expectedResult)
  }
  test("Finding length of List[Int] ") {
    val actualResult = testAcceptor1.length(List(-16, -2, -565, -77, -34))
    val expectedResult = 5
    actualResult should equal(expectedResult)
  }
  test("Finding length of List[Any] ") {
    val actualResult = testAcceptor1.length(List("sdas", 12, 324, 324.0))
    val expectedResult = 4
    actualResult should equal(expectedResult)
  }
  test("Finding length of Empty String ") {
    val actualResult = testAcceptor1.length(List())
    val expectedResult = 0
    actualResult should equal(expectedResult)
  }
  test("Finding 2th element from last in a List") {
    val actualResult = testAcceptor1.elementFromLast(List(-16, -2, -565, -77, -34),2)
    val expectedResult = -77
    actualResult should equal(expectedResult)
  }
  test("Finding 5th element from last in a List") {
    val actualResult = testAcceptor1.elementFromLast(List(-16, -2, -565, -77, -34),5)
    val expectedResult = -16
    actualResult should equal(expectedResult)
  }


}
