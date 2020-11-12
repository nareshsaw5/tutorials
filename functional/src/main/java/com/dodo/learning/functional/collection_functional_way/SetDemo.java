package com.dodo.learning.functional.collection_functional_way;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SetDemo {

    public static void main(String[] args) {
        Set<Integer> number = Set.of(2, 4, 5, 3, 6, 8, 19);

        // traversal
        number.forEach(System.out::println);

        System.out.println("---------");

        //filter only even numbers
        number.stream()
                .filter( n -> n%2 ==0)
                .forEach(System.out::println);

        System.out.println("---------");
        // sorting
        number.stream().sorted()
                .forEach(System.out::println);

        System.out.println("---------");

        //convert the type through map
        Set<Double> numbersInDouble = number.stream().map(e -> e.doubleValue()).collect(Collectors.toSet());
        numbersInDouble.forEach(System.out::println);
        System.out.println("---------");

        // use TreeSet to get the sorted data
        TreeSet<Integer> treeSet = number.stream().collect(Collectors.toCollection(TreeSet::new));
        treeSet.forEach(System.out::println);
        System.out.println("---------");


        // get the sume, you can use longer route as reduce but this is shorter
        int sum = number.stream()
                .mapToInt( e -> e.intValue())
                .sum();
        System.out.println(sum);


    }
}
