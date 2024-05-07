package com.dodo.tutorials.synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {



    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(4000);
        for (int i = 0; i < 20000 ; i++) {
            int finalCounter = i;
            service.submit( () -> {
               new Sync().syncFn(finalCounter);
            });
        }
        service.shutdown();
    }
}

class Sync {
    private final Object lock = new Object();
     void syncFn(int count){
         synchronized(lock) {
             System.out.println("Status "+Thread.currentThread().getState());
             System.out.println("sync function");
             try {
                 if (count == 2000) {
                     System.out.println("Count is 10000");
                 }
                 System.out.println("Going for sleep");
                 Thread.sleep(5);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
         }
         if(!Thread.holdsLock(lock)){
             System.out.println("Status.... "+Thread.currentThread().getState());
         }
    }
}
