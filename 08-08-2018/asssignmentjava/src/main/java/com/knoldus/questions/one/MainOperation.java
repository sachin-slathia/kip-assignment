package com.knoldus.questions.one;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainOperation {

    public static void main(String[] args) {

        Student first = new Student("Sachin", 1,
                Optional.of(Arrays.asList("Chemistry", "Maths", "Physics")));

        Student second = new Student("Slathia", 2,
                Optional.empty());
        Student third = new Student("Rudar", 2,
                Optional.of(Arrays.asList("Chemistry", "Maths", "Computer")));

        Student fourth = new Student("Rudar", 2,
                Optional.empty());

        ClassRoom one = new ClassRoom("xyz",
                Optional.of(Arrays.asList(first, second, third, fourth)));
        ClassRoom two = new ClassRoom("abc",
                Optional.of(Arrays.asList(second)));


        List<ClassRoom> list = Arrays.asList(one, two);

        System.out.println(list);

        System.out.println(one);


        System.out.println(one.studentList.get().stream().
                filter(x -> !x.subject.isPresent())
                .collect(Collectors.toList()));


        List list1 = list.stream().filter(x -> "xyz".equals(x.roomID)).collect(Collectors.toList());

        System.out.println(list1);


        System.out.println(list.stream().filter(x->"xyz".equals(x.roomID)).collect(Collectors.toList()));


    }
}
