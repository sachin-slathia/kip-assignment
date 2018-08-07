package com.knoldus;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountWord {

    public static void main(String[] args) {

        String input = "sdaasd dasd as  Dasd sa";


        Map<String, Integer> wordCounter1 = Stream.of(input).map(w -> w.split("\\s+"))
                .flatMap(Arrays::stream)
                .collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum));
        System.out.println(wordCounter1);
    }
}
