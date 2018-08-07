package com.knoldus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MultiplyList {


    public static void main(String[] args) {

        List<Integer> firstList = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> secondList = Arrays.asList(1, 2, 32, 421, 5);

        List<Integer> resultList = new ArrayList<>();
        Iterator iterator = secondList.iterator();

        //Multiply List 1 elements with List 2 elements
        if (firstList.size() == secondList.size()) {
            firstList.forEach(num -> resultList.
                    add(Math.multiplyExact(num, (Integer) iterator.next())));

            System.out.println(resultList);
        }
        else
            System.out.println("Two list can only be multiplied with same size ");
    }

}