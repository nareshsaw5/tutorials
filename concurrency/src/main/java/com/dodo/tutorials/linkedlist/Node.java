package com.dodo.tutorials.linkedlist;

public class Node {
    private Object value;
    Node next;

    public Node(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString(){
        return "[ "+this.value+", next -> "+this.next.value+" ]";
    }
}
