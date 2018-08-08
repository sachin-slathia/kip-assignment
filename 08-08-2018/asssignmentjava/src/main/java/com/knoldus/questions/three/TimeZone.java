package com.knoldus.questions.three;

import java.time.Instant;
import java.time.ZoneId;

public class TimeZone {

    public static void main(String[] args) {

        System.out.println(Instant.now().atZone
                          (ZoneId.of("America/Los_Angeles")));

    }
}
