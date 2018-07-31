package com.knoldus

import com.knoldus.itemCategories.{Furniture, HouseHold, Medicine}
import org.scalatest.{FunSuite, Matchers}

class CalculateBillSpec extends  FunSuite with Matchers {

  val billCalculate = new CalculateBill

  test("Calculating bill amount for user shopping list.") {

    val listOfItems: List[ItemsInformation] = List(
      new Medicine("Cough Syrup", 35, 5),
      new Furniture("Bed", 1000, 2),
      new HouseHold("Broom", 50, 5)

    )
    val actualResult = billCalculate.totalBillCalculator(listOfItems)
    val expectedReusult = 3181.25
    expectedReusult shouldBe actualResult

  }
}