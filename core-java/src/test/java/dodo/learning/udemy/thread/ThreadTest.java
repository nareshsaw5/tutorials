package dodo.learning.udemy.thread;

import org.junit.jupiter.api.Test;

public class ThreadTest {

    @Test
    public void testThread() throws InterruptedException {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("Intentional Exception");
            }
        });
        t.setName("Misbehaving thread");
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("An critical error is reported in the thread " + t.getName()
                        + " and the exception is " + e.getMessage());

            }
        });

        t.start();
    }

    @Test
    public void testCustomThreadClass() {
        Thread t = new MyThread();
        t.start();

    }

    @Test
    public void testInterrupted() {
        Thread t = new Thread(new BlockingThread());
        t.start();
        System.out.println("Main thread");
        t.interrupt();
    }

    

    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(" Thread name " + this.getName());
        }
    }

}
