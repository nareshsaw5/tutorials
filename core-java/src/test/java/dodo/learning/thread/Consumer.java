package dodo.learning.thread;

public class Consumer {

    public static void main(String[] arg) {
        final Counter count = new Counter(0);
        new MyThread(count).start();
        System.out.println("--------");
        new MyThread2(count).start();
    }
}

class MyThread extends Thread {

    Counter counter = new Counter(0);

    MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getCount() < 100) {
            counter.increement();
            System.out.println(Thread.currentThread() + ", after " + counter.getCount());

        }
    }
}

class MyThread2 extends Thread {
    Counter counter;

    MyThread2(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getCount() < 100) {
            counter.increement();
            System.out.println(Thread.currentThread() + ", after " + counter.getCount());

        }
    }
}

class Counter {
    
    int count;

    Counter(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    public void increement() {
        System.out.println(Thread.currentThread() +" with "+this.count);
        this.count++;
    }
}
