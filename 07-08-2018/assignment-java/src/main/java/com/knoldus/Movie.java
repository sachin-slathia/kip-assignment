package com.knoldus;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Movie {
    String name;

    Integer ReleaseYear;
    Double Rating;
    String Genre;

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
        movieList.add(new Movie("Abc", 2018, 8.1, "Comedy"));
        movieList.add(new Movie("xyz", 2017, 5.0, "Romance"));
        movieList.add(new Movie("fsd", 2018, 7.5, "Action"));
        movieList.add(new Movie("fsdfsf", 2006, 9.0, "Scary"));


        System.out.println(movieList.stream().filter(movie -> (movie.Rating > 8)
                && movie.Genre.equalsIgnoreCase("comedy"))
                .collect(Collectors.toList()));


        System.out.println(movieList.stream().filter(movie -> (movie.Rating < 8)
                && movie.ReleaseYear > 2000)
                .collect(Collectors.toList()));

        System.out.println(movieList.stream().filter(movie -> (movie.Rating % 2 == 0))
                .collect(Collectors.toList()));

        System.out.println(movieList.stream().filter(movie -> (movie.Rating == 7)
                && movie.Genre.equalsIgnoreCase("Sci-Fi"))
                .collect(Collectors.toList()));


    }


}
