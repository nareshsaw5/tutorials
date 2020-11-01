package com.dodo.tutorials.datastructure.linkedlist;

public class DoubleLinkedList {

    private Node head;

    public void add(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node curr = head;
        Node prev = head;
        Node next = head;

        while (curr != null) {
            prev = curr;
            curr = curr.getNext();
        }
        // here curr should be null after while loop
        curr = new Node(data);
        prev.setNext(curr);
        curr.setPrev(prev);
    }

    public void remove(int data) {
        Node curr = get(data);
        if (curr == null) {
            return;
        }
        Node prev = curr.getPrev();
        Node next = curr.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        curr = null;
    }

    public Node get(int data) {
        if (isEmpty()) {
            return null;
        }

        Node curr = head;
        while (curr != null) {
            if (curr.getData().equals(data)) {
                return curr;
            }
            curr = curr.getNext();
        }

        return null;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

}
