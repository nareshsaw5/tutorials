package dodo.learning.udemy.thread;

public class InventoryConcurrencyTest {

    public static void main(String[] arg) throws InterruptedException {
        Inventory inventory = new Inventory();
        Thread incThread = new IncrementThread(inventory);
        Thread decThread = new DecrementThread(inventory);

        incThread.start();
        decThread.start();

        incThread.join();
        decThread.join();

        System.out.println("Counter : " + inventory.getCounter());

    }

    static class IncrementThread extends Thread {

        private Inventory inventory;

        public IncrementThread(Inventory inventory) {
            this.inventory = inventory;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                inventory.increment();
            }
        }
    }

    static class DecrementThread extends Thread {

        private Inventory inventory;

        public DecrementThread(Inventory inventory) {
            this.inventory = inventory;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                inventory.decrement();
            }
        }
    }

    static class Inventory {

        private int counter;
        private Object lock = new Object();

        public void increment() {
            // critical section
            synchronized (this.lock) {
                ++counter;
            }
        }

        public void decrement() {
            synchronized (this.lock) {
                --counter;
            }
        }

        public int getCounter() {
            return this.counter;
        }

    }

}
