package com.dodo.learnings.generics.linkedlist;

public class LinkedList<E> {

    private Node<? extends Number> head;

    public void insert(E data){
        if(head == null){
            head = (Node<Number>) new Node<>(data);
        }
        Node<? extends Number> curr = head;
        Node<? extends Number> prev = head;

        while( curr != null){
            prev = curr;
            curr = curr.getNext();
        }

        curr = new Node(data);
        prev.setNext(curr);
    }

    public void print(){
        Node<? extends Number> curr = head;
        while (curr != null){
            System.out.println(curr);
            curr = curr.getNext();
        }
    }


}
