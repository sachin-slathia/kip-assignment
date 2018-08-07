package com.knoldus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiplyList {


    public static void main(String[] args) {

        List<Integer> firstList = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> secondList = Arrays.asList(1, 2, 32, 421, 5, 9);

        List<Integer> resultList = new ArrayList<>();
        firstList.forEach(num -> secondList.forEach(num2 -> resultList.
                add(Math.multiplyExact(num, num2))));

        System.out.println(resultList);
    }
}