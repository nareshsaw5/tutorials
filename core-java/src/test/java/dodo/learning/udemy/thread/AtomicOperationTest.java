package dodo.learning.udemy.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicOperationTest {
    
    public static void main(String[] ar) throws InterruptedException {
        
        AtomicCounter counter = new AtomicCounter();
        
        Thread increment = new IncrementThread(counter);
        
        Thread decrement = new DecrementThread(counter);
        
        increment.start();
        decrement.start();
        
        increment.join();
        decrement.join();
        
        System.out.println("Counter "+counter.getCounter());
        
        
    }
    
    static class IncrementThread extends Thread{ 
        
        private AtomicCounter counter;
        
        IncrementThread(AtomicCounter counter){
            this.counter = counter;
        }
        
        public void run() {
            for(int i=0 ; i<10000; i++) {
                counter.increase();
            }
        }
    }
    
    static class DecrementThread extends Thread{ 
        
        private AtomicCounter counter;
        
        DecrementThread(AtomicCounter counter){
            this.counter = counter;
        }
        
        @Override
        public void run() {
            for(int i=0 ;i< 10000; i++) {
                counter.decrease();
            }
        }
        
        
    }
    
    static class AtomicCounter {
        private AtomicInteger counter = new AtomicInteger();
        
        public AtomicInteger getCounter() {
            return counter;
        }

        public void increase() {
            counter.incrementAndGet();
        }
        
        public void decrease() {
            counter.decrementAndGet();
        }
        
        
    }
    

}
