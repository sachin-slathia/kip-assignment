package com.knoldus.models

case class Student(id: Int, name: String) {

 override def toString: String = {
    s"Student id=$id,Student name=$name"
  }

}