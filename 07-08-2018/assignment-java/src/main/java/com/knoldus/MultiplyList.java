/*
package com.knoldus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultiplyList {

    public static void main(String[] args) {

        List list1 = Arrays.asList(1, 2, 3, 4, 5);
        List list2 = Arrays.asList(1, 2, 32, 421, 5, 9);

        System.out.println(list1);
        System.out.println(list2.size());

        if (list1.size() == list2.size()) {
            List list3 = list1.stream().map(s1 -> list2.
                    stream().map(s3 -> (Integer) s3 * (Integer) s1)).collect(Collectors.toList());

        } else {
            System.out.println("Two list can only be multiplied when there size is same");
        }
    }
}
*/
