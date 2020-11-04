package com.dodo.tutorials.datastructure.queue;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueMain {

    public static void main(String[] args) {
        Queue arrayBlockingQueue = new LinkedBlockingQueue(10);
        arrayBlockingQueue.offer(20);
        arrayBlockingQueue.offer(10);
        arrayBlockingQueue.offer(30);

        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());

        System.out.println("-------");
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.offer(20);
        priorityQueue.offer(40);
        priorityQueue.offer(10);
        priorityQueue.offer(30);

        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }
}
