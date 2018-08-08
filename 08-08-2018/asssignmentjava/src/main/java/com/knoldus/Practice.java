package com.knoldus;

import java.time.*;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Practice {

    public static void main(String[] args) {


        System.out.println(IntStream.range(1990, LocalDate.now().getYear()).
                boxed().filter(year -> LocalDate.of(year, 1, 1).isLeapYear()).
                collect(Collectors.toList()));

        System.out.println(IntStream.range(1995, LocalDate.now().getYear()).
                boxed().map(year -> LocalDate.of(year, 12, 15).
                getDayOfWeek()).collect(Collectors.toList()));


        LocalDateTime birthDate = LocalDateTime.of(1869, 10, 2, 10, 20, 55);

        LocalDateTime deathDate = LocalDateTime.of(1948, 1, 31, 10, 20, 55);

        System.out.println(Instant.now().atZone(ZoneId.of("America/Los_Angeles")));

        System.out.println(Duration.between(birthDate, deathDate)
                           .getSeconds());



    }

}
