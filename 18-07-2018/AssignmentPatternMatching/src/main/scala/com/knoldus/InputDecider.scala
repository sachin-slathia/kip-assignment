package com.knoldus

class InputDecider {

  def matchInput(input: Any): String = {
    input match {

      case s: String => s"you have given me a String $input"
      case i: Int => s"thanks for giving Int $input"
      case f: Float => s"thanks for giving float $input"
      case a: Array[Int] => "you have entered Array[Int]"
      case a: Array[String] => "you have given me a Array[String]"
      case l: List[Any] => s"thanks for giving a List[Any]"
      case c: Pet => s"thanks for giving name of your pet"
      case m: Map[_, _] => s"you have entered Map[ , ]"
      case _ => "Sorry not in our application please pass another value"

    }
  }

}

case class Pet(name: String)





