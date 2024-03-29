package com.knoldus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Movie {

    private Integer id;
    private String name;
    private String releaseDate;
    private String releaseYear;
    private Double rating;
    private String actor;
    private String director;

    public static List<Movie> movieList = new ArrayList<>();
    private static Set<Integer> idSet = new HashSet<>();
    private static Scanner input = new Scanner(System.in);

    //Constructor
    Movie(Integer id, String name, String releaseDate, String releaseYear, Double rating,
          String actor, String director) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.actor = actor;
        this.director = director;

    }

    @Override
    public String toString() {
        return "MovieId= " + id + " MovieName= " + name +
                " ReleaseDate= " + releaseDate + " ReleaseYear= " + releaseYear +
                " rating= " + rating + " Actor= " + actor + " Director= " + director;
    }


    //Adds movies to Movie List
    public static void addMovies() {
        Boolean checkId = true;
        Integer movieId = 0;
        while (checkId) {
            System.out.println("Enter the movie id");

            try {
                movieId = input.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Oops you have entered a value that is not Integer Enter Again");

            }
                if (!idSet.contains(movieId)) {
                    idSet.add(movieId);
                    checkId = false;
                } else System.out.println("Record already exists ");

            }

        System.out.println("Enter the movie name");
        String movieName = input.next();

        System.out.println("Enter the releaseDate of movie in format dd-mm-yyyy");
        String releaseDate = input.next();

        System.out.println("Enter the releaseYear of movie in format yyyy");
        String releaseYear = input.next();

        System.out.println("Enter the rating of movie (1-10)");
        Double movieRating=0.0;
        try {
             movieRating = input.nextDouble();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Only integers are allowed");
        }


        System.out.println("Enter the actor of movie");
        String actor = input.next();

        System.out.println("Enter the director of movie ");
        String director = input.next();

        Movie movie = new Movie(movieId, movieName, releaseDate,
                releaseYear, movieRating, actor, director);

        movieList.add(movie);

    }

    // Returns movie according to its Id
    public static Optional<List<Movie>> getMovie(Integer movieId) {

        List<Movie> movieById = movieList.stream().filter(movie -> movie.id.equals(movieId)).
                collect(Collectors.toList());

        return !movieById.isEmpty() ? Optional.of(movieById) : Optional.empty();
    }
    /*public static void updateList(Integer movieId)
    {
        Optional result=Movie.getMovie(movieId);

        if(result.isPresent())
        {
            System.out.println("Enter the name you want to update");

            String updatedName=input.next();
            Movie movie=(Movie)result.get();
            System.out.println("dasdas"+movie);
            movie.name=updatedName;
            System.out.println(movie);

        }
    }
*/
    // Return List of movies
    public static Optional<List<Movie>> getListMovie() {

        return !movieList.isEmpty()?Optional.of(movieList):Optional.empty();
    }

    // Delete movie according to its Id
    public static List<Movie> deleteMovie(Integer movieId) {

        return movieList.stream().filter(movie -> movie.id != movieId).collect(Collectors.toList());
    }
    //Returns List according to offset
  public static List<Movie> getMovies(Integer offset, Integer limit) {

      System.out.println(movieList.get(offset));
      return movieList;
    }


    // Returns List of movies whose rating is more than 8 and director name is equals to given name
    public static Optional<List<Movie>> filterMovie(String directorName) {

        List<Movie> updatedList = movieList.stream().filter(movie -> movie.rating > 8 &&
                movie.director.equals(directorName))
                .collect(Collectors.toList());

        return !updatedList.isEmpty() ? Optional.of(updatedList) : Optional.empty();

    }

    // Returns List of movies whose realease data is greater date is greater than date passed
    public static Optional<List<Movie>> filterMovieDate(String datePassed) {


        List<Movie> updatedList = movieList.stream().filter(movie -> LocalDate
                                   .parse(movie.releaseDate, DateTimeFormatter.ofPattern("d-MM-yyyy"))
                                     .isAfter(LocalDate.parse(datePassed, DateTimeFormatter.ofPattern("d-MM-yyyy"))))
                                       .collect(Collectors.toList());

        return !updatedList.isEmpty() ? Optional.of(updatedList) : Optional.empty();

    }

    // Returns List of movies whose Release Date is between startDate and endDate
    public static Optional<List<Movie>> filterMovieDate(String startDate, String endDate) {

        List<Movie> updatedList = movieList.stream().filter(movie -> LocalDate
                                   .parse(movie.releaseDate, DateTimeFormatter.ofPattern("d-MM-yyyy"))
                                     .isAfter(LocalDate.parse(startDate, DateTimeFormatter.ofPattern("d-MM-yyyy"))) &&
                                      LocalDate.parse(endDate, DateTimeFormatter.ofPattern("d-MM-yyyy"))
                                        .isAfter(LocalDate.parse(movie.releaseDate, DateTimeFormatter.ofPattern("d-MM-yyyy"))))
                                         .collect(Collectors.toList());

        return !updatedList.isEmpty() ? Optional.of(updatedList) : Optional.empty();

    }

    // Returns List of movies whose release Year is  between startYear and endYear
    public static Optional<List<Movie>> filterMovieYear(String startYear, String endYear) {

        List<Movie> updatedList =  movieList.stream().filter(movie -> Integer.parseInt(movie.releaseYear) >
                                    Integer.parseInt(startYear)
                                     && Integer.parseInt(movie.releaseYear) <=
                                       Integer.parseInt(endYear)).collect(Collectors.toList());

        return !updatedList.isEmpty() ? Optional.of(updatedList) : Optional.empty();


    }

    public static Optional<Map<String, Long>> moviesPerDirector(){

        List<String> updatedList = movieList.stream()
                .map(movie -> movie.director)
                .collect(Collectors.toCollection(ArrayList::new));

        return !updatedList.isEmpty() ? Optional.of(updatedList.stream()
                    .filter(directorName -> !directorName.isEmpty())
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())))
                    :Optional.empty();
    }


    }




