package com.knoldus.questions.three;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZone {

// Returns Zoneid of given Sring

    public static ZonedDateTime zoneInformation(String input) {

        return Instant.now().atZone
                (ZoneId.of("America/Los_Angeles"));

    }

    public static void main(String[] args) {

        System.out.println(zoneInformation("America/Los_Angeles"));

    }
}
