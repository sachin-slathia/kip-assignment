package com.knoldus

class Person(val name: String, var age: Int) {


  override def equals(that: Any): Boolean = that match {
    case that: Person => this.name == that.name && this.age == that.age
    case _ => false
  }

  override def hashCode(): Int = 41 *(41+name.length())


}



