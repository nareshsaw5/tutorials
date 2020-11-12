package com.dodo.learnings.generics.linkedlist;

import java.math.BigInteger;

public class LinkedListDemo {

    public static void main(String[] args) {

        LinkedList<Number> linkedList = new LinkedList<>();
        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.insert(30);
        linkedList.insert(40);
        linkedList.insert(50);
        linkedList.insert(20.40);
        linkedList.insert(20000000L);

        linkedList.print();

        BigInteger bigInteger = BigInteger.valueOf(Long.MAX_VALUE);
        System.out.println(bigInteger.intValue());
        System.out.println(Integer.MAX_VALUE);

    }
}
