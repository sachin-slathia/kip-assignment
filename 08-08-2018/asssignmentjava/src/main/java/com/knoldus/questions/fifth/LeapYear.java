package com.knoldus.questions.fifth;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeapYear {

    public static void main(String[] args) {
        System.out.println(IntStream.range(1990, LocalDate.now().getYear()).
                boxed().filter(year -> LocalDate.of(year, 1, 1).isLeapYear()).
                collect(Collectors.toList()));
    }
}
