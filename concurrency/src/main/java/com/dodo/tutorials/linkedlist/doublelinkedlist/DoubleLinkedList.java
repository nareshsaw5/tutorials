package com.dodo.tutorials.linkedlist.doublelinkedlist;


public class DoubleLinkedList {
    private Node head = null;
    private Node tail = null;
    int size;

    public DoubleLinkedList() {
    }

    public void add(Object val){
        Node node = new Node(val);
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }else {
            node.prev = this.tail;
            this.tail.next = node;
            this.tail = node;
        }
        size++;
    }

    public Object remove(){
        Node current = this.head;
        if(current != null) {
            this.head = current.next;
            if (this.head != null) this.head.prev = null;
            current.next = null;
        }
        return current;
    }

    public int size(){
        return size;
    }

    public void print(){
        Node current = this.head;
        while(current != null){
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    private void printReverse(){
        Node current = this.tail;
        while(current != null){
            System.out.println(current.getValue());
            current = current.prev;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.print();
        System.out.println("========");
        list.printReverse();
    }
}
