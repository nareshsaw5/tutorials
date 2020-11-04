package dodo.learning.udemy.thread;

public class BlockingThread implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println("Sleeping");
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            System.out.println(" I am interrupted "+Thread.currentThread().getName());
        }
        
    }

}
