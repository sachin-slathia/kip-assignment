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

    public void insertFields()
    {

        Student first =new Student("Sachin",1,
                Optional.of(Arrays.asList("Chemistry","Maths","Physics")));

        Student second =new Student("Slathia",2,
                Optional.of(Arrays.asList()));

    }

}
