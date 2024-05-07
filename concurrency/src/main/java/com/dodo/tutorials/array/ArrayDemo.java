package com.dodo.tutorials.array;

import java.util.ArrayList;

public class ArrayDemo {

    public static void main(String[] args) {
        int[] ar = new int[2];
        ar[0] = 1;
        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }

        String[]  list = new String[10];
        list[0] = "Hello";
        list[3] = "Soni";
        for (int i  = 0; i  < list.length ; i ++) {
            System.out.println(list[i]);
        }

    }
}
