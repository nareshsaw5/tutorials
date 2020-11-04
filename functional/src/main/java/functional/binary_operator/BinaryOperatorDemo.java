package functional.binary_operator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.BinaryOperator;

public class BinaryOperatorDemo {

    public static void main(String[] args) throws InterruptedException {
        BinaryOperator<String> binary = (s1, s2) -> s1.toLowerCase() +"."+s2.toLowerCase();

        System.out.println(binary.apply("Hello","Naresh"));


        Counter counter = new Counter();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            service.submit( () -> counter.increment());
        }
        service.shutdown();
        service.awaitTermination(60, TimeUnit.MILLISECONDS);
        System.out.println(counter.getCount());


    }
    static class Counter {

        private int count;

        private void increment(){
            count++;
        }

        public int getCount() {
            return count;
        }
    }
}
