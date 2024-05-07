package com.dodo.tutorials.linkedlist.doublelinkedlist;

public class Node {
    private Object value;
    Node prev;
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

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString(){
//        return "[ "+this.prev.value+" <-prev "+this.value +", next-> "+this.next.value+" ]";
        return this.value.toString();
    }
}
