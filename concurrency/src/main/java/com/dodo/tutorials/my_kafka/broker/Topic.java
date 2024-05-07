package com.dodo.tutorials.my_kafka.broker;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Topic {
    Random random = new Random(2);
    private String name="Default";

    private int partitionCount = 5;

    private List<Partition> partitions;

    public Topic(){
        partitions = new ArrayList<>(partitionCount);
    }
    public Topic(int partitionsCount){
        partitions = new ArrayList<>(partitionsCount);
        for(int i = 0 ;i < partitionsCount; i++){
            partitions.add(new Partition(""+i, 2));
        }
        this.partitionCount = partitionsCount;
    }

    public Topic(String name, int partitionsCount){
        this.name = name;
        partitions = new ArrayList<>(partitionsCount);
        for(int i = 0 ;i < partitionsCount; i++){
            partitions.add(new Partition(""+i, 2));
        }
        this.partitionCount = partitionsCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getPartitionCount() {
        return partitionCount;
    }

    public void setPartitionCount(int partitionCount) {
        this.partitionCount = partitionCount;
    }

    public List<Partition> getPartitions() {
        return partitions;
    }

    public void setPartitions(List<Partition> partitions) {
        this.partitions = partitions;
    }

    public boolean produce(String message){
        // get the partitions and select one of them
        Partition partition = this.getPartitions().get(random.nextInt(2)); // hard coded
        System.out.println("pushing in partition "+partition.getName());
        AtomicInteger offset = partition.getOffset();
        Message m = new Message(offset.get(), message);
        offset.getAndIncrement();
        // push to the queue
        return partition.getQueue().offer(m);
    }

    public Message  consume(){
        Partition partition = this.getPartitions().get(0); // hard coded
        return partition.getQueue().poll();
    }
}
