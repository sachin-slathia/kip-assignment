package com.knoldus

class FindOperations {


  def maximumElement(list: List[Int], element: Int = Integer.MIN_VALUE): Int = {
    list match {
      case Nil => element
      case _ => if (list.head > element) maximumElement(list.tail, list.head)
      else maximumElement(list.tail, element)
    }
  }

  def minimumElement(list: List[Int], element: Int = Integer.MAX_VALUE): Int = {
    list match {
      case Nil => element
      case _ => if (list.head < element) minimumElement(list.tail, list.head)
      else minimumElement(list.tail, element)
    }
  }

  def length(list: List[Any], element: Int = 0): Int = {
    list match {
      case Nil => element
      case _ => length(list.tail, element + 1)

    }
  }

  def elementFromLast(list: List[Int], n: Int): Int = {

    list.length - n match {
      case 0 => list.head
      case _ => elementFromLast(list.tail, n)

    }
  }

}

