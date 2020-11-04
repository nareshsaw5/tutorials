package com.example.dodo.lambda;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;

public class LambdaMethodReferenceTest {

    @Test
    public void testMethodReference(){
        List names = Arrays.asList("naresh","suresh","dinesh");

        //method reference example in lambda, here i m calling println method of System.out. The method name
        // could be static method, instance function or constructor. The function name is separated by ::
        names.forEach(System.out::println);


    }

    @Test
    public void testFunctionalInterface(){

        Function<String, Integer> function = (x) -> x.length();
        Function<List, Integer> arFunc = (x) -> {
            x.forEach(System.out::println);
            return 0;
        };

        int sum = 0;
        arFunc.apply(Arrays.asList(0,1,2,3, sum));
        System.out.println(function.apply("naresh"));
    }

    @Test
    public void testFunctionChain(){
        Function<String, Integer> len = (x) -> x.length();
        Function<Integer, Integer> multiply = (x) -> x * 2;

        int v = len.andThen(multiply).apply("naresh");
        System.out.println(v);

        Function<String, String> reverse = (x) -> {
            char[] org = x.toCharArray();
            char[] rev = new char[org.length];
            for(int i=0, j=org.length-1; i < org.length; i++, j--){
                rev[i] = org[j];
            }
          return new String(rev);
        };

        String rev = reverse.apply("naresh");
        System.out.println(rev);

        Function<Integer, Boolean> isEven = (x) -> x % 2 == 0;
        Function<Integer, Boolean> isOdd = (x) -> x %2 == 1;

        isEven.apply(2);
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        numbers.forEach( (x) -> {
            if(isEven.apply(x)){
              System.out.println("Even "+x);
            } else {
                System.out.println("Odd "+x);
            }
        });

        List<String> list = Arrays.asList("node", "c++", "java", "javascript");
        // lambda
        Map<String, Integer> map = convertListToMap(list, x -> x.length());
    }

     static <T, R> Map<T, R> convertListToMap(List<T> list, Function<T, R> func) {

        Map<T, R> result = new HashMap<>();
        for (T t : list) {
            result.put(t, func.apply(t));
        }
        return result;
    }

}
