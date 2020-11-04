package dodo.learning.udemy.thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue orders = new ArrayBlockingQueue(2);
        Thread producer = new Producer(orders);
        Thread consumer = new Consumer(orders);

        producer.start();
        consumer.start();
        producer.join();
        System.out.println("Main is out");

    }

    static class Producer extends Thread {
        private BlockingQueue<Integer> orders;

        Producer(BlockingQueue orders) {
            this.orders = orders;
        }

        @Override public void run() {
            while (true) {
                try {
                    Random random = new Random();
                    Integer nextOrder = random.nextInt(100);
                    System.out.println("producing " + nextOrder);
                    orders.put(nextOrder);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer extends Thread {

        private BlockingQueue<Integer> orders;

        Consumer(BlockingQueue orders){
            this.orders = orders;
        }

        @Override
        public void run(){
            while (true){
                try {
                    Integer order = orders.take();
                    System.out.println("Consuming order "+order);
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        }

    }

}
