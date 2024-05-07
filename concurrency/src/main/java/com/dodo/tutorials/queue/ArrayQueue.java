package com.dodo.tutorials.queue;

public class ArrayQueue {
    private Object[] elements = null;
    private int size = 10;
    private int putIndex = 0;
    private int takeIndex = 0;

    public ArrayQueue() {
        elements = new Object[size];
    }

    public ArrayQueue(int size) {
        this.size = size;
        elements = new Object[size];
    }

    public void enqueue(Object val){
        this.elements[putIndex] = val;
        putIndex++;
    }

    public Object dequeue(){
        Object obj = this.elements[takeIndex];
        takeIndex++;
        return obj;
    }

    public static void main(String[] args) {
        ArrayQueue queue  = new ArrayQueue(4);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.println("++++++++");
        for (int i = 0; i <queue.size ; i++) {
            System.out.println(queue.dequeue());
        }
    }

}
