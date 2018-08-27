package com.knoldus.streams.repository

case class Employee(Id:Int,FIRST_NAME:String,LAST_NAME:String,GENDER:String)


object Main extends App{

  val originalStream=Stream(Employee(1,"Sachin","Slathia" ,"Male"),
                           Employee(2,"Rudar","Daman" ,"Female"))



/*  println(originalStream.print())


/*  val updatedStream=originalStream.map(employee => Person(employee.id,
    if (employee.gender.equalsIgnoreCase("MAle")) s"Mr ${employee.firstName} " +
      s"${employee.lastName}" else s"Miss ${employee.firstName} ${employee.lastName}"))*/


  print(updatedStream.print())*/


}


