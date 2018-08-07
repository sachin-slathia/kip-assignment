package com.knoldus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PrimeNumbers {

    //Add element to List
    public static List<Integer> insert(List<Integer> list) {
        Random random = new Random();

        for (int number = 0; number < 10; number++) {
            int randomNumber = random.nextInt(100);
            list.add(randomNumber);
        }
        return list;
    }
    //Returns whether number is prime or not
    public static boolean isPrimeNumber(int number) {
        int factors = 0;
        int j = 1;

        while(j <= number)
        {
            if(number % j == 0)
            {
                factors++;
            }
            j++;
        }
        return (factors == 2);
    }

    //Prints the List
    public static void printList(List<Integer> arrayList) {
        System.out.println("Contents of al: " + arrayList);
    }

    //Updates the given List
    public static List<Integer> updateList(List<Integer> list){


        List updatedList = list.stream().filter(PrimeNumbers::isPrimeNumber).
                collect(Collectors.toList());

       return updatedList;
    }

    public static void main(String[] args) {

       List<Integer> list = new ArrayList<Integer>();
        insert(list);
        printList(list);
        list =updateList(list);
        printList(list);

    }
}
