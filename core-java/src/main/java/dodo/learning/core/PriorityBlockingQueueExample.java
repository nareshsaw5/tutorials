package dodo.learning.core;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue   = new PriorityBlockingQueue();
        queue.add("b");
        queue.add("c");
        queue.add("a");

        System.out.println(queue.take());
    }
}
