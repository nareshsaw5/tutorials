package com.dodo.learning.reactive.callback;

public class CallbackDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            new CallbackDemo().runningAsAsynch(new CallBack() {

                @Override public void pushData(String data) {
                    System.out.println("Pushed "+data);
                }

                @Override public void pushComplete() {
                    System.out.println("Callback is done");

                }

                @Override public void pushError(Exception e) {
                    System.out.println(e.getMessage());
                }
            });
        });
        t.start();
        System.out.println("Main is done");
        t.join();

    }

    private void runningAsAsynch(CallBack callBack) {
        System.out.println("I am running async");
        sleep();
        callBack.pushData("Data1");
        callBack.pushData("Data2");
        callBack.pushData("Data3");
        callBack.pushError(new RuntimeException("Oops!"));
        callBack.pushComplete();
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
