package com.dodo.tutorials.my_kafka.broker;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Partition {
    private String name="default";

    private AtomicInteger offset = new AtomicInteger(0);

    private AtomicInteger committedOffset = new AtomicInteger(0);

    private ArrayBlockingQueue<Message> queue;

    public Partition(String name, int capacity){
        this.name = name;
        queue = new ArrayBlockingQueue<>(capacity);
    }

    public Partition(int capacity){
        queue = new ArrayBlockingQueue<>(capacity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AtomicInteger getOffset() {
        return offset;
    }

    public void setOffset(AtomicInteger offset) {
        this.offset = offset;
    }


    public AtomicInteger getCommittedOffset() {
        return committedOffset;
    }

    public void setCommittedOffset(AtomicInteger committedOffset) {
        this.committedOffset = committedOffset;
    }

    public ArrayBlockingQueue<Message> getQueue() {
        return queue;
    }

    public void setQueue(ArrayBlockingQueue<Message> queue) {
        this.queue = queue;
    }


}
