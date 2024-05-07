package com.dodo.tutorials.deadlock;

import java.util.Random;

public class DeadlockMain {

    public static void main(String[] args) {

        Intersection intersection = new Intersection();
        Thread trainAThread = new Thread(new TrainA(intersection));
        Thread trainBThread = new Thread(new TrainB(intersection));

        trainAThread.start();
        trainBThread.start();

    }


    static class TrainA implements Runnable {

        private Intersection intersection;
        private Random random = new Random();

        public TrainA(Intersection intersection) {
            this.intersection = intersection;
        }

        public void run(){
            while (true){
                try {
                    Thread.sleep(random.nextInt(5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                intersection.takeRoadA();
            }
        }
    }

    static class TrainB implements Runnable {

        private Intersection intersection;
        private Random random = new Random();

        public TrainB(Intersection intersection) {
            this.intersection = intersection;
        }

        public void run(){
            while (true){
                try {
                    Thread.sleep(random.nextInt(5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                intersection.takeRoadB();
            }
        }
    }

    static class Intersection {

        private Object roadA = new Object();
        private Object roadB = new Object();

        public void takeRoadA(){
            synchronized (roadA){
                System.out.println("Got lock of road A by " +Thread.currentThread().getName());
                System.out.println("Waiting for road B");
                synchronized (roadB){
                    System.out.println("Passing through Road A");
                }
            }
        }

        public void takeRoadB(){
            synchronized (roadB){
                System.out.println("Got lock of road B by "+Thread.currentThread().getName());
                System.out.println("Waiting for road A");
                synchronized (roadA){
                    System.out.println("Passing through Road B");
                }
            }
        }


    }
}
