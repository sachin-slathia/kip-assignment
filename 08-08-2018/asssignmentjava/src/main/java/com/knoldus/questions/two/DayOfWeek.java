package com.knoldus.questions.two;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DayOfWeek {
    public static void main(String[] args) {

        System.out.println(IntStream.range(1995, LocalDate.now().getYear()).
                boxed().map(year -> LocalDate.of(year, 12, 15).
                getDayOfWeek()).collect(Collectors.toList()));

    }

}
