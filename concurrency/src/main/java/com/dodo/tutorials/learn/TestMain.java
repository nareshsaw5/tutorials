package com.dodo.tutorials.learn;

public class TestMain {

    public static void main(String[] args) {
    new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Hello Naresh");
        }
    }).start();

    new Thread( () -> {
        System.out.println("Hey Naresh");
    }).start();

    System.out.println("Done");

    try {
        Thread.currentThread().join(0);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    }


}
