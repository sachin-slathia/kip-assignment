package com.knoldus

abstract class ItemsInformation {

  val name: String
  val price: Double
  val quantity: Int

  def priceCalculator: Double
}
