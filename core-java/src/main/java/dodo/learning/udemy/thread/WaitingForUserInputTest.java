package dodo.learning.udemy.thread;

import java.io.IOException;

public class WaitingForUserInputTest {

    public static class WaitingForUserInput implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    char input = (char) System.in.read();
                    if (input == 'q') {
                        return;
                    }
                    System.out.println(input);
                }
            } catch (IOException e) {
                System.out.println("An exception was caught " + e);
            }
            ;
        }
    }
    
    public static void main(String[] arg) throws InterruptedException {
        Thread t = new Thread(new WaitingForUserInput());
        t.start();
        System.out.println("Exiting main thread");
    }

}
