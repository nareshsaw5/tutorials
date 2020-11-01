package com.dodo.tutorials.datastructure.linkedlist;

import org.junit.jupiter.api.Test;

public class CircularLinkedListTest {

    private CircularLinkedList list;

    @Test void testAdd() {
        list = new CircularLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list);
    }
}
