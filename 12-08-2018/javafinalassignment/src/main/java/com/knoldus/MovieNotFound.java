package com.knoldus;

// Our Own Exception Class
public class MovieNotFound extends Exception {

    public MovieNotFound(String s){
        super(s);
    }
}
