package com.knoldus.itemCategories
import com.knoldus.ItemsInformation

  class Medicine(val name: String, val price: Double, val quantity: Int)
    extends ItemsInformation  {


    def priceCalculator: Double = price * quantity

}
