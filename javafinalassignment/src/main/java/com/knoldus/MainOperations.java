package com.knoldus;


import java.util.Optional;
import java.util.Scanner;

public class MainOperations {
    public static void main(String[] args)throws MovieNotFound {

        Scanner input=new Scanner(System.in);
        Boolean condition=true;
        while(condition)
        {
            System.out.println("Enter 1 for adding Movies in List \n" +
                    "Enter 2 for searching a list by its id \n"+
                    "Enter 3 for getting a list \n" +
                    "Enter 4 for deleting a list by its id \n"+
                    "Enter 6 for searching list br director name \n" +
                            "Enter 7 for searching a list by startDate and end date \n"+
                            "Enter 9 for searching a list by Date  \n" +
                            "Enter 8 for searching a list by startYear and endYear \n"
            );
            System.out.println("Enter the desired choice");

            Integer choice=input.nextInt();
            switch (choice)
            {
                case 1: Movie.addMovies();
                        break;
                case 2: {
                    System.out.println("Enter the movie id you want to get");
                    Integer movieId =input.nextInt();
                    Optional result=Movie.getMovie(movieId);
                    if(result.isPresent())
                        System.out.println("Movie with id"+movieId+ "=" +result.get());
                    else
                        throw new MovieNotFound("The movie Id you are trying to access does not exist");
                    break;
                }
                case 3:{

                    Optional result = Movie.getListMovie();
                    if (result.isPresent())
                        System.out.println("List"+result.get());
                    else throw new MovieNotFound("The movie List does not exist");
                    break;

                }
                case 4:{
                    System.out.println("Enter the movie id you want to delete");
                    Integer movieId =input.nextInt();
                    Movie.movieList=Movie.deleteMovie(movieId);
                    break;
                }
                case 5:{
                    System.out.println("Enter the movie id you want to delete");
                    Integer movieId =input.nextInt();
                   Movie.movieList=Movie.deleteMovie(movieId);
                    break;
                }
                case 6:{
                    System.out.println("Enter the director name you want to search");
                    String director =input.next();
                    Optional result=Movie.filterMovie(director);
                    if(result.isPresent()){
                        System.out.println("vgjhg"+result.get());}
                    else
                        throw new MovieNotFound("No Movie found as per director");
                    break;
                }
                case 7:{
                    System.out.println("Enter the start date(dd-mm-yyyy) and  end date(dd-mm-yyyy)");
                    String startDate =input.next();
                    String endDate =input.next();
                    Optional result=Movie.filterMovieDate(startDate,endDate);
                    if(result.isPresent()){
                        System.out.println("Movies in range"+result.get());}
                    else
                        throw new MovieNotFound("No Movie found as per director");
                    System.out.println(Movie.filterMovieDate(startDate,endDate));
                    break;
                }
                case 8:{
                    System.out.println("Enter the start date(dd-mm-yyyy) ");
                    String startDate =input.next();
                    Optional result=Movie.filterMovieDate(startDate);

                    if(result.isPresent()){
                        System.out.println("Movies in range"+result.get());}
                    else
                        throw new MovieNotFound("No Movie lies in Date you entered");

                }

                case 9:{
                    System.out.println("Enter the start year(yyyy) and  end year(yyyy) ");
                    String startYear =input.next();
                    String endYear=input.next();
                    Optional result=Movie.filterMovieYear(startYear,endYear);

                    if(result.isPresent()){
                        System.out.println("Movies in range"+result.get());}
                    else
                        throw new MovieNotFound("No Movie lies in years you entered");
                    break;
                }
                 default:
                     System.out.println("Invalid choice");

            }


        }

    }



}
