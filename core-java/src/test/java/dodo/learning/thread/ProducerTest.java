package dodo.learning.thread;

import java.util.Random;
import org.junit.jupiter.api.Test;

public class ProducerTest {

    @Test
    public void testProducer() throws InterruptedException {
        Integer dishes[] = new Integer[1];
        new Producer(dishes).start();
        new ConsumerThread(dishes).start();
        Thread.currentThread().join(5000);
    }

}

class Producer extends Thread {

    private Integer[] dishes;

    Producer(Integer[] stack) {
        this.dishes = stack;
    }

    @Override
    public void run() {
        while (true) {
            if (dishes[0] == null) { // no dish, so produce to eat
                int dish = new Random().nextInt();
                System.out.println("Producing dish " + dish);
                dishes[0] = dish;
            } else { // Let the dish to be eaten
                try {
                    System.out.println("Producer Sleeping");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}

class ConsumerThread extends Thread {
    private Integer[] dishes;

    ConsumerThread(Integer[] dishes) {
        this.dishes = dishes;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            if (dishes[0] == null) {
                try {
                    System.out.println("No dish to eat, hence sleeping");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Eating dish " + dishes[0]);
                dishes[0] = null;
            }
        }
    }

}
