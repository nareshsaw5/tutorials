package com.dodo.tutorials.condition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {

    public static void main(String[] args) {
        Message msg = new Message();
        Thread messageProducer = new Thread(new MessageProducer(msg));
        Thread messageViewer = new Thread(new MessageViewer(msg));
        messageProducer.start();
        messageViewer.start();
    }

    static class MessageProducer extends Thread {

        private Message message;

        public MessageProducer(Message message) {
            this.message = message;
        }

        @Override public void run() {
            publishMessage();
        }

        public void publishMessage(){
            List<String> msgs = new ArrayList<>();
            msgs.add("Hello");
            msgs.add("current project is complete");
            msgs.add("here is the estimation for new project");

            for (String msg: msgs) {
                message.publishMessage(msg);
                try{
                    Thread.sleep(400);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            message.publishMessage("bye");
            message.setEndIt(true);
        }
    }

    static class MessageViewer extends Thread {
        private Message message;

        public MessageViewer(Message message) {
            this.message = message;
        }

        @Override public void run() {
            while (!message.isEndIt()) {
                message.viewMessage();
            }
        }
    }

    static class Message {

        private Lock lock = new ReentrantLock();
        private Condition produceMsg = lock.newCondition();
        private Condition consumeMsg = lock.newCondition();
        private boolean messageState;
        private String message;
        private boolean endIt;

        public void publishMessage(String message) {

            lock.lock();
            try{
                while (messageState){
                    consumeMsg.await();
                }

                System.out.println("Adding latest message");
                this.message = message;
                messageState = true;
                produceMsg.signal();
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }


        }

        public void viewMessage() {
            lock.lock();
            try {
                // has no new message, wait for it
                while (!messageState) {
                    produceMsg.await();

                }
                System.out.println("Got latest message " + message);
                // message consumed, notify waiting thread
                produceMsg.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public boolean isEndIt(){
            return endIt;
        }

        public void setEndIt(boolean endIt){
            this.endIt = endIt;
        }

    }

}


