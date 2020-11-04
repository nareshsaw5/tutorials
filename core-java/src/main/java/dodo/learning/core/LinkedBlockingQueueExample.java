package dodo.learning.core;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> lbq = new LinkedBlockingQueue<String>();
        lbq.add("Naresh");
        lbq.add("Suresh");
        lbq.add("Dinesh");

        System.out.println(lbq.take());

        BlockingQueue<String> abq = new ArrayBlockingQueue<>(10);
        abq.add("Naresh");
        abq.add("Suresh");
        abq.add("Dinesh");
        System.out.println(abq.take());


    }
}
