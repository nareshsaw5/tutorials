package com.dodo.tutorials.datastructure.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    private LinkedList<Integer> list;

    @Test void testInsert() {
        list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(5);
        list.add(7);
        list.add(2);
        System.out.println(list);
    }
    @Test void testPrint() {
        list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(5);
        list.add(7);
        list.add(2);
        list.print();
    }

    @Test void testCount() {
        list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(5);
        list.add(7);
        list.add(2);
        int count = list.size();
        System.out.println(count);
    }

    @Test void testGet() {
        list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(5);
        list.add(7);
        list.add(2);
        Node node = list.get(2);
        Assertions.assertNotNull(node);
    }

    @Test void testRemove() {
        list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(5);
        list.add(7);
        list.add(2);
        list.remove(10);
        Node node = list.get(10);
        System.out.println(list);
    }
}

