package example;

public class RunnableLambdaExample {
    public static void main(String[] args) {
        //prior to 8
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("running "+Thread.currentThread().getName());
            }
        }).start();

        // java 8 onwards
        // lambda syntax
        // () -> {}
        new Thread( () -> System.out.println("running post java 8 "+Thread.currentThread().getName())).start();

    }
}
