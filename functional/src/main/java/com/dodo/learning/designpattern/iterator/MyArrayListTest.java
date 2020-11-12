package com.dodo.learning.designpattern.iterator;

public class MyArrayListTest {

    public static void main(String[] args) {
        int[] ar = new int[]{1,2,4,5};

        MyArrayList list = new MyArrayList<Integer>(new Object[]{1,2,3,4});
        list.forEach(System.out::println);

    }
}
