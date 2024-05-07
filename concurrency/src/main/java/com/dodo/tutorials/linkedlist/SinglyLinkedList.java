package com.dodo.tutorials.linkedlist;

public class SinglyLinkedList {
    private Node head;
    private Node tail;

    public void add(Object val){
        Node newNode = new Node(val);
        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    public void print(){
        Node currentNode = this.head;
        while(currentNode.next != null){
            System.out.println(currentNode);
            currentNode = currentNode.getNext();
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.print();
    }
}
