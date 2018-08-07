package com.knoldus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountWord {

    public static void main(String[] args) {

        String input = "sdaazxdas a a a a as  Dasd sa";
        List<List<Object>> list = new ArrayList<>();

        //Counts every element in list
        Map<String, Integer> wordCounter = Stream.of(input).map(w -> w.split("\\s+"))
                .flatMap(Arrays::stream)
                .collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum));

        //Adds map tuples to list
        wordCounter.keySet().forEach(ele -> list.add(Arrays.asList(ele, wordCounter.get(ele))));

        System.out.println(list);
    }
}
