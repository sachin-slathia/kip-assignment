package com.knoldus.questions.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Student {

    @Override
    public String toString() {
        return String.format(name+ " " + rollNumber +" "+subject );
    }


    String name;
    Integer rollNumber;
    Optional<List<String>>  subject;
    Student(String name,Integer rollNumber,Optional<List<String>> subject)
    {
        this.name=name;
        this.rollNumber=rollNumber;
        this.subject=subject;
    }


    public String getName() {
        return this.name;
    }
    public int getRollNo() {
        return this.rollNumber;
    }
    public Optional<List<String>> getSubject() {
        return this.subject;
    }
}
