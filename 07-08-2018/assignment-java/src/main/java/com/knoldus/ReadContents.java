package com.knoldus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadContents {

    //Finds All occurences of every word in File
    public static Map<String, Integer> findAllOccurences(BufferedReader readFile) throws Exception {

        Map<String, Integer> repeatedWords = new HashMap<>();
        String line = readFile.readLine();
        while (line != null) {

            String words[] = line.toLowerCase().split(" ");
            for (String word : words) {
                if (repeatedWords.containsKey(word))
                    repeatedWords.put(word, repeatedWords.get(word) + 1);
                else
                    repeatedWords.put(word, 1);

            }
            line = readFile.readLine();
        }

        return repeatedWords;
    }

    // Returns the List in decreasing order
    public static List<Map.Entry<String, Integer>> sortByValueInDecreasingOrder(Map<String, Integer> wordMap) {
        Set<Map.Entry<String, Integer>> entries = wordMap.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(entries);
        Collections.sort(list, (o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
        return list;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader
                ("/home/knoldus//kip-assignment/30-07-2018/generateBills/build.sbt"));

        Map<String, Integer> wordCount = new HashMap<>();
        try {
            wordCount = findAllOccurences(br);
        } catch (Exception e) {
            e.printStackTrace();
        }
       List repeatedWord=sortByValueInDecreasingOrder(wordCount);

        System.out.println(repeatedWord.get(0));


    }
}
