package com.dodo.tutorials.lock;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWDictionary {

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();
    private Map<String, String> dictionary = new TreeMap<String, String>();

    public void put(String key, String value) {
        System.out.println("Thread in put"+Thread.currentThread().getName());
        writeLock.lock();
        try {
            dictionary.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public String get(String key) {
        System.out.println("Thread in Get"+Thread.currentThread().getName());
        readLock.lock();
        try {
            return dictionary.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public void clear() {
        writeLock.lock();
        try {

        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        final RWDictionary rwDictionary = new RWDictionary();
        Random random = new Random();
        for (int i = 0; i <1000 ; i++) {
            Thread t = new WriterThread(rwDictionary, random);
            Thread t1= new ReaderThread(rwDictionary, random);
            t.start();
            t1.start();
        }
        Thread.currentThread().join();

    }

    static class WriterThread extends Thread {

        private RWDictionary rwDictionary;
        private Random random;

        public WriterThread(RWDictionary rwDictionary, Random random) {
            this.rwDictionary = rwDictionary;
            this.random = random;

        }

        @Override public void run() {
            String key =  "" + random.nextInt(100);
            System.out.println("Putting key "+key);
            rwDictionary.put(key, key);
        }
    }

    static class ReaderThread extends Thread {

        RWDictionary rwDictionary;
        Random random;

        public ReaderThread(RWDictionary rwDictionary, Random random) {
            this.rwDictionary = rwDictionary;
            this.random = random;
        }

        @Override public void run() {
            String key =  "" + random.nextInt(100);
            System.out.println("Getting key "+key);
            String v = rwDictionary.get(key);
            System.out.println(v);
        }
    }
}