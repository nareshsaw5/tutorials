package com.dodo.tutorials.queue;

import com.dodo.tutorials.linkedlist.doublelinkedlist.DoubleLinkedList;

public class LinkedListQueue {
    private DoubleLinkedList list;

    public LinkedListQueue() {
        list = new DoubleLinkedList();
    }

    public void enqueue(Object val){
        list.add(val);
    }

    public Object dequeue(){
        return list.remove();
    }
    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.println("+++++++");
        for (int i = 0; i < queue.size() ; i++) {
            System.out.println(queue.dequeue());
        }
    }

}
