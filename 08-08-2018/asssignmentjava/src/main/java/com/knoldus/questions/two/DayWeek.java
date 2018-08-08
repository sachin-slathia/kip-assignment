package com.knoldus.questions.two;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class DayWeek {

    public static List<DayOfWeek> getDay(Integer date, Integer month, Integer year) {

        return IntStream.range(year, LocalDate.now().getYear()).
                boxed().map(year1 -> LocalDate.of(year1, month, date).
                getDayOfWeek()).collect(Collectors.toList());

    }

    public static void main(String[] args) {

        System.out.println(getDay(15, 12, 1995));

    }

}
