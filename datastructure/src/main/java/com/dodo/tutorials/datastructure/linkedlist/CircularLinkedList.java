package com.dodo.tutorials.datastructure.linkedlist;

public class CircularLinkedList {

    private Node head;
    private Node tail;

    public void add(int data){
        if(head == null){
            head = tail = new Node(data);
            // first time, set head next as tail, which is same
            head.setNext(tail);
            return;
        }
        Node tmp = tail;
        Node newNode = new Node(data);
        // TODO, how to find the next node and set it to head
        // we can use counter
        if(head.getNext() == tail ){
            head.setNext(newNode);
        }
        tail = newNode;
        tail.setPrev(tmp);
    }
}
