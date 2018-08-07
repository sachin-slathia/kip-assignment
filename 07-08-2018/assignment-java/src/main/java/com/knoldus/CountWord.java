package com.knoldus;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountWord {

    public static void main(String[] args) {

        String input = "sdaazxdas a a a a as  Dasd sa";
        List<List<Object>> list = new ArrayList<>();
        Map<String, Integer> wordCountMap = new HashMap<>();

        //Counts every element in list

        Stream.of(input.split("[\\s^,]+")).forEach(word ->
                  wordCountMap.put(word.toLowerCase(), wordCountMap.get(word.toLowerCase()) != null ?
                  wordCountMap.get(word.toLowerCase()) + 1 : 1));

        //Adds map tuples to list
        wordCountMap.forEach((k, v) -> list.add(Arrays.asList(k, v)));

        System.out.println(list);
    }
}
