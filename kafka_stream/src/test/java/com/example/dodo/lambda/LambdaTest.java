package com.example.dodo.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaTest {

    @Test
    public void testLambadaExpression(){

        // This is called lambda expression, the fat arrow function in javascript
        //(parameter1, parameter2) -> { code block }

        //(parameter1, parameter2) -> {}

        List names = Arrays.asList("naresh","suresh","dinesh");
        names.forEach( (name) -> {
            System.out.println(name);
        });

        //Consumer interface, we can use like this
        Consumer<String> method = (n) -> System.out.println(n);

        names.forEach(method);
    }

    @Test
    public void testMyLambdaFunction(){
        String name = "naresh";
        MyFunction appendFunc = (s) -> s + "!";
        MyFunction doubleAppend = (s) -> s + "!!";
        MyFunction exclaim = (s) -> s + "!";
        MyFunction ask = (s) -> s + "?";
        print("Hello", exclaim);
        print("Hello", ask);
        print(name, appendFunc);
        print(name, doubleAppend);
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
        print(numbers);
    }

    @Test
    public void testCustomLambdaFunciton(){

        Greetings sayHello = (s) -> {
            System.out.println("Hello "+s);
        };

        sayHello.greet("Naresh");

    }

    interface Greetings {
        void greet(String s);
    }










    void print(String s, MyFunction myFunction){
        String appendedString = myFunction.append(s);
        System.out.println(appendedString);
    }

    void print(List list){
        list.forEach( (item) -> {
            System.out.println(item);
        });
    }

    /**
     *
     */
    interface StringFunction {
        String run(String str);
    }

    interface MyFunction {
        String append(String s);
    }
}
