package com.knoldus.questions.fifth;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeapYear {

//Returns List of All Leap Years till today date
    public static List<Integer> findLeapYears(int range)
    {
        return IntStream.range(range, LocalDate.now().getYear()).
                boxed().filter(year -> LocalDate.of(year, 1, 1).isLeapYear()).
                collect(Collectors.toList());
    }


    public static void main(String[] args) {

        System.out.println(findLeapYears(1990));
    }
}
