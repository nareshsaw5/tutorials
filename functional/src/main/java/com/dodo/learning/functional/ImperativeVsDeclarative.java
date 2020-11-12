package com.dodo.learning.functional;

import java.util.stream.IntStream;

public class ImperativeVsDeclarative {

    public static void main(String[] args) {

        // Imperative way
        int sum = 0;

        for (int i = 0; i < 100 ; i++) {

            if(i % 2 == 0){
                sum += i;
            }

        }
        System.out.println(sum);

        // Declarative/Functional style
        int sumOfEven = IntStream.rangeClosed(1, 99)
                .filter( (i) -> i % 2 == 0)
                .reduce( (x, y) ->  x+y)
                .getAsInt();

        System.out.println(sumOfEven);
    }
}
