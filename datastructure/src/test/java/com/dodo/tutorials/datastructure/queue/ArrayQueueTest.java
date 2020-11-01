package com.dodo.tutorials.datastructure.queue;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class ArrayQueueTest {

    ArrayQueue<Integer> queue = new ArrayQueue(Integer.class);

    @Test void testAddOrOffer() {
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        System.out.println(queue.size());
        int el = queue.poll();
        System.out.println(el);
        el = queue.poll();
        System.out.println(el);
        System.out.println(queue.size());
    }
}
