
package com.knoldus


class CalculateBill {

  def totalBillCalculator(list: List[ItemsInformation]):Double ={

  list match{
    case Nil => 0

    case x::tail => (x.quantity * x.priceCalculator) + totalBillCalculator(tail)

  }

  }

}
