package com.knoldus.questions.one;

import java.util.List;
import java.util.Optional;

 //Defined class Student
public class Student {

    @Override
    public String toString() {
        return String.format(name+ " " + rollNumber +" "+subject );
    }


    String name;
    Integer rollNumber;
    Optional<List<String>>  subject;

      //Constructor
    Student(String name,Integer rollNumber,Optional<List<String>> subject)
    {
        this.name=name;
        this.rollNumber=rollNumber;
        this.subject=subject;
    }

     //Returns name of Current Object
    public String getName() {
        return this.name;
    }
     //Returns RollNo of Current Object
    public int getRollNo() {
        return this.rollNumber;
    }
    //Returns List of Subject of particular Student
    public Optional<List<String>> getSubject() {
        return this.subject;
    }
}
