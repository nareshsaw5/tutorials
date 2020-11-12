package com.dodo.learning.functional.bifunction;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BiFunctionDemo {

    public static void main(String[] args) {

        String s = "is is is naresh naresh is a man naresh can talk like a man";

        // basically we need to create count of each word and return in a map
        Function<String, Map<String, Integer>> fn = (sentence) -> {
            Map<String, Integer> map = new HashMap<>();
            String[] ar = sentence.split(" ");
            int count = 0;
            for (String str :ar) {
                str = str.trim();
                count = map.getOrDefault(str, 0);
                map.put(str, 1+count);
            }
          return map;
        };

       // System.out.println(fn.apply(s));

        Function<List<Integer>, Map<Integer,Boolean>> isPrimeFn = (list) -> {
            Map<Integer, Boolean> primeMap = new HashMap<>();
            Function<Integer, Boolean> isPrime = (n) -> {
                for (int i = 2; i < n; i++) {
                    if(n % i == 0){
                        return false;
                    };
                }
                return true;
            };
            for (Integer v: list) {
                primeMap.put(v, isPrime.apply(v));

            }
            return primeMap;
        };

        Map<Integer, Boolean> primeMap = isPrimeFn.apply(Arrays.asList(3,5,7,9,11,12,15));
        System.out.println(primeMap);


        // ------
        // BiFunction demo
        BiFunction<String, String, Integer> biF = (s1, s2) -> (s1 + s2).length();
        System.out.println(biF.apply("hi", "hi"));

        //--------
        // change first to last and last to first character in the string
        Function<String, String> changeSeqFn = v -> {
            return new StringBuilder().append(v.substring(v.length()-1)).append(v.substring(1, v.length()-1)).append(v.substring(0,1)).toString();
        };

        System.out.println(changeSeqFn.apply("naresh"));
        System.out.println(changeSeqFn.apply("aba"));


        BiFunction<String, String, List<Person>> biFunction = (name, n) -> {
            List<Person> list = new ArrayList<>();
            list.add(new Person(name));
            return list;
        };

        Person person = biFunction.apply("Naresh", "Naresh").get(0);
        System.out.println(person);




    }
}


class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override public String toString() {
        return "Person{" + "name='" + name + '\'' + '}';
    }
}
