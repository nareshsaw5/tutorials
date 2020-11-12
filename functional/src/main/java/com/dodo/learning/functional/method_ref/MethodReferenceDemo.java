package com.dodo.learning.functional.method_ref;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceDemo {

    public static void main(String[] args) {

        Supplier<Double> sup = Math::random;
        System.out.println(sup.get());

        BiFunction<Integer, Integer, Integer> biFunction = MethodReferenceDemo::add;
        // the above can be written as
        // Bifunction has 3 parameter, the below bifunction takes two parameter and return third parameter
        BiFunction<Integer, Integer, Integer> biFunction2 = (n1, n2) -> n1 + n2;
        System.out.println(biFunction.apply(5, 10));

        BiFunction<Integer, Integer, Integer> minFn = Math::min;
        System.out.println(minFn.apply(5, 19));

        Function<List<Integer>, Integer> minValueFn = MethodReferenceDemo::findMin;
        List<Integer> list = Arrays.asList(2,5,1,8,9);
        System.out.println(minValueFn.apply(list));


        Function<String, Integer> lenFn = String::length;
        System.out.println(lenFn.apply("Naresh"));

        Function<String, String> lowerCaseFn = String::toLowerCase;
        // the above can be written like this
        Function<String, String> lowerCaseFn2 = (v) -> v.toLowerCase();
        System.out.println(lowerCaseFn.apply("Naresh"));
        System.out.println("--------");


        // try Function from List to Map
        Function<List<Integer>, Map<String, String>> convertListToMapFn = numberList -> {
            Map<String, String> map = new HashMap<>();
            for (Integer v: numberList) {
                map.put(""+v, ""+v);
            }
            return map;
        };

        Map<String, String> numberMap = convertListToMapFn.apply(List.of(1,2,3));
        numberMap.forEach( (k, v) -> {
            System.out.println(k +" "+v);
        });




    }

    static Integer add(Integer a, Integer b) {
        return a + b;
    }

    static Integer findMin(List<Integer> list) {
        Integer minValue = list.get(0);
        for (int i = 1; i <list.size() ; i++) {
            if(minValue > list.get(i)){
                minValue  = list.get(i);
            }

        }
        return minValue;
    }
}
