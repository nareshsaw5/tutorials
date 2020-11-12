package com.dodo.learnings.generics.linkedlist;

public class Node<E> {

    private E data;
    private Node<? extends Number> next;

    public Node(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<? extends Number> getNext() {
        return next;
    }

    public void setNext(Node<? extends Number> next) {
        this.next = next;
    }

    @Override public String toString() {
        return "Node{" + "data=" + data + ", next=" + next + '}';
    }
}
