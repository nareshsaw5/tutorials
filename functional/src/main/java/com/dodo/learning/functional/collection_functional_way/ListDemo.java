package com.dodo.learning.functional.collection_functional_way;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ListDemo {

    public static void main(String[] args) {

        List<Movie> movies = Arrays.asList(
                new Movie("Spotlight",2015,"Hollywood"),
                new Movie("Avengers: Infinity War",2018,"Hollywood"),
                new Movie("Inception",2010,"Hollywood"),
                new Movie("Forest Gump",1994,"Hollywood"),
                new Movie("3 Idiots",2009,"Bollywood"),
                new Movie("Beauty and the beast",2017,"Hollywood"),
                new Movie("Slumdog Millionaire",2008,"Bollywood"));


        // Traversing
        movies.forEach(System.out::println);
        System.out.println("-----------");

        // sort
        // with natural order
        movies.sort( (o1, o2) -> o1.getReleaseYear() - o2.getReleaseYear() );
        movies.forEach(System.out::println);

        System.out.println("-----------");

        // filter
        movies.stream()
                .filter( movie -> movie.getIndustry().contains("Bolly")
                ).forEach(System.out::println);
        System.out.println("-----------");

        //mapping
        List<String> movieNames = movies.stream().map((movie) -> movie.getName()).collect(Collectors.toList());
        System.out.println(movieNames);
        System.out.println("-----------");

        // reduce, I need all the movie names in string, separated by ,
        Optional<String> optionalS = movies.stream()
                .map( movie -> movie.getName())
                .reduce(  (m1, m2) -> m1 + ", "+m2);
        String s = optionalS.get();
        System.out.println(s);



    }
}
