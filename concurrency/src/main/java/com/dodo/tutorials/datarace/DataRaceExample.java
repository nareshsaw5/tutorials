package com.dodo.tutorials.datarace;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataRaceExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        ExecutorService service = Executors.newFixedThreadPool(20);
        for (int i = 0; i <  1000 ; i++) {
            service.submit( () -> {
                //counter.increase(); // not thread safe, no lock, data race condition
                counter.increaseWithLock(); // no data race, increase is guarded by a lock
            });
        }
        service.shutdown();
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);
        System.out.println("count now "+counter.getCount());
    }
}


class Counter {

    private int count;

    private Lock lock = new ReentrantLock();

    /**
     * This is not thread safe, can give unpredictable value in multi-thread environment
     */
    public void increase(){
        ++count;
    }

    /**
     * This is thread safe version of increase function.
     * It can give a predictable output in multi-thread environment
     * @return
     */
    public void increaseWithLock(){
        lock.lock();
        try{
            ++count;
        }finally {
            lock.unlock();
        }
    }


    public int getCount(){
        return this.count;
    }


}
