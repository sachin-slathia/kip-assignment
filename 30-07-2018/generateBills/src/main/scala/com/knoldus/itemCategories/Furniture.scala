package com.knoldus.itemCategories

import com.knoldus.{ItemsInformation, VatInformation}

class Furniture (val name: String, val price: Double, val quantity: Int)
   extends ItemsInformation with VatInformation {

    def priceCalculator: Double = price + (price * vat)/100

}
