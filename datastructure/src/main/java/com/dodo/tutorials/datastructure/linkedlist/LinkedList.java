package com.dodo.tutorials.datastructure.linkedlist;

public class LinkedList<T extends Comparable> {

    private Node<T> head;

    public void add(T value){
        // if head is null, create new Element with value and return
        if(head == null){
            head = new Node(value);
            return;
        }

        Node curr = head;
        Node prev = head;
        while(curr != null){
            prev = curr;
            curr = curr.getNext();
        }
        curr = new Node(value);
        // make sure, you set the current node as next node to prev node
        prev.setNext(curr);
    }

    /**
     *
     */
    public void print(){
        if(head == null){
            System.out.println("List is empty");
        }

        Node curr = head;
        while( curr != null){
            System.out.println(curr.getData());
            curr = curr.getNext();
        }
    }

    /**
     *
     * @return
     */
    public int size(){
        if(head == null){
            return 0;
        }
        Node curr = head;
        int count = 0;
        while(curr !=null){
            count++;
            curr = curr.getNext();
        }

        return count;
    }

    public Node get(int data){
        if(head == null){
            return null;
        }
        Node curr = head;
        Node prev = head;

        while(curr != null){
            if(curr.getData().equals(data)){
                return curr;
            }
            curr = curr.getNext();
        }
        return null;
    }

    private Node getPrevious(int data){
        if (head == null) {
            return null;
        }
        Node curr = head;
        Node prev = head;
        while(curr != null){
            if(curr.getData().equals(data)){
                return prev;
            }
            prev = curr;
            curr = curr.getNext();
        }

        return null;
    }

    public void remove(int data){
        Node curr = get(data);
        if (curr == null) {
            return;
        }
        Node prev = getPrevious(data);
        // this is head case
        if(prev == curr){
            head = curr.getNext();
        }else {
            prev.setNext(curr.getNext());
        }
        curr = null; // remove the node
    }



}
