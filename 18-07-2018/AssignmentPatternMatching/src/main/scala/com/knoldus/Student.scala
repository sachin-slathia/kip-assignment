package com.knoldus

class Student(id: Int, name: String, division: Int, section: String)


object Student {

  def apply(id: Int, name: String, division:Int, section: String) = new Student(id, name, division, section)
}




