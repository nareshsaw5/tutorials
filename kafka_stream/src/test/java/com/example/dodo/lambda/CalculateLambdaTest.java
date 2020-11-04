package com.example.dodo.lambda;

import org.junit.jupiter.api.Test;

public class CalculateLambdaTest {

    @Test public void testCalculator() {

        Calculator addMethod = (numbers) -> {
            int sum = 0;
            for(Integer n: numbers){
                sum += n;
            }
            return sum;
        };

        Calculator subMethod = (numbers) -> {
            int sum = 0;
            Integer first = numbers[0];
            Integer second = numbers[1];
            if(first > second ){
                sum = first - second;
            }else {
                sum = second-first;
            }
            System.out.println(String.format("Returning diff of %s and second %s as : %s", first, second, sum));
            return sum;
        };

        Integer[] numbers = new Integer[]{2, 3, 4};
//        print(addMethod, numbers);
//        print(subMethod, numbers);
        System.out.println(addMethod.calculate(numbers));
    }

    void print(Calculator calculator, Integer... integers){
        System.out.println(calculator.calculate(integers));
    }

    interface Calculator {
        int calculate(Integer... integers);
    }
}
