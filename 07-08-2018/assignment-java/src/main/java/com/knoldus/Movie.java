package com.knoldus;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Movie {
    String name;

    Integer ReleaseYear;
    Double Rating;
    String Genre;

    //Constructor
    Movie(String name, Integer ReleaseYear, Double Rating, String Genre) {
        this.name = name;
        this.ReleaseYear = ReleaseYear;
        this.Rating = Rating;
        this.Genre = Genre;
    }

    @Override
    public String toString() {

        return String.format(name + " " + ReleaseYear + " " + Rating + " " + Genre);
    }

    public static void main(String[] args) {

        List<Movie> movieList = new LinkedList<Movie>();
        //Added elements to list
        movieList.add(new Movie("Abc", 2018, 8.1, "Comedy"));
        movieList.add(new Movie("xyz", 2017, 5.0, "Romance"));
        movieList.add(new Movie("fsd", 2018, 7.5, "Action"));
        movieList.add(new Movie("fsdfsf", 2006, 9.0, "Scary"));


        //Prints Movies information where Rating is greater than 8 and Genre is comedy
        System.out.println(movieList.stream().filter(movie -> (movie.Rating > 8)
                && movie.Genre.equalsIgnoreCase("comedy"))
                .collect(Collectors.toList()));

        //Prints Movies information where Rating is greater than < 8 and ReleaseYear is 2000
        System.out.println(movieList.stream().filter(movie -> (movie.Rating < 8)
                && movie.ReleaseYear > 2000)
                .collect(Collectors.toList()));

        //Prints Movies information where Rating is even value
        System.out.println(movieList.stream().filter(movie -> (movie.Rating % 2 == 0))
                .collect(Collectors.toList()));


        //Prints Movies information where Rating is equal to 7 and Genre  is Sci-Fi
        System.out.println(movieList.stream().filter(movie -> (movie.Rating == 7)
                && movie.Genre.equalsIgnoreCase("Sci-Fi"))
                .collect(Collectors.toList()));


    }


}
