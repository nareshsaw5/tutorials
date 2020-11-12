package com.dodo.learning.functional;

public class StringFunctionalTest {

    public static void main(String[] args) {

        StringFunctionalInteface sub = s -> s.substring(0, 1);
        System.out.println(sub.modify("Naresh"));

        sub = s -> s.toLowerCase();
        System.out.println(sub.modify("Naresh"));

        sub = s -> s.toUpperCase();
        System.out.println(sub.modify("naresh"));

        sub = s -> {
            System.out.println(s);
            return s.trim();
        };

        System.out.println(sub.modify(" I need to be trimmed    "));
    }
}
