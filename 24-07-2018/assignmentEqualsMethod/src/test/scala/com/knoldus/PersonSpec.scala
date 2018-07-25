package com.knoldus


import org.scalatest.{BeforeAndAfter, FunSuite, Matchers}

import scala.collection.mutable

class EqualsMethodSpec extends FunSuite with Matchers with BeforeAndAfter {


  val equalsComparison = new Person("Sachin", 23)


  test("Testing on two objects when name and age are same ") {
    val equalsComparison1 = new Person("Sachin", 23)
    val actualResult = equalsComparison equals equalsComparison1
    val expectedResult = true
    actualResult should equal(expectedResult)
  }
  test("Testing on two objects when name is same , age is different ") {
    val equalsComparison2 = new Person("Sachin", 25)
    val actualResult = equalsComparison equals equalsComparison2
    val expectedResult = false
    actualResult should equal(expectedResult)
  }
  test("Testing on two objects when name and age are different ") {
    val equalsComparison3 = new Person("Sachin453", 25)
    val actualResult = equalsComparison equals equalsComparison3
    val expectedResult = false
    actualResult should equal(expectedResult)
  }
  test("Testing whether object is present in HashSet or not ") {
    val equalsComparison3 = new Person("Sachin453", 25)
    val hash = mutable.HashSet(equalsComparison3)
    val actualResult = hash contains equalsComparison3
    val expectedResult = true
    actualResult should equal(expectedResult)
  }
  test("Testing whether object is present in HashSet when we increment age") {
    val equalsComparison3 = new Person("Sachin453", 25)
    val hash = mutable.HashSet(equalsComparison3)
    equalsComparison3.age = 30
    val actualResult = hash contains equalsComparison3
    val expectedResult = true
    actualResult should equal(expectedResult)
  }


}
