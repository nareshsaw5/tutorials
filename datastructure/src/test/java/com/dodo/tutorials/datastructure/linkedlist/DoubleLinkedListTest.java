package com.dodo.tutorials.datastructure.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DoubleLinkedListTest {

    DoubleLinkedList list;

    @Test void testAdd() {
        list = new DoubleLinkedList();
        list.add(10);
        list.add(20);
        list.add(40);
        list.add(5);
        System.out.println(list);
    }

    @Test void testGet() {
        list = new DoubleLinkedList();
        list.add(10);
        list.add(20);
        list.add(40);
        list.add(5);
        Node node = list.get(20);
        Assertions.assertTrue(node.getData().equals(20));
        node = list.get(21);
        Assertions.assertNull(node);
    }

    @Test void testRemove() {
        list = new DoubleLinkedList();
        list.add(10);
        list.add(20);
        list.add(40);
        list.add(5);
        list.remove(20);
        Node node  = list.get(20);
        Assertions.assertNull(node);
    }
}
