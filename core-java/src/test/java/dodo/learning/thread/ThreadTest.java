package dodo.learning.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;


public class ThreadTest {

    @Test
    public void testFuture() {

    }

    @Test
    public void testNewRunnable() throws InterruptedException {
        new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName());
                for (int i = 0; i < 10; i++) {
                    try {
                        System.out.println(i);
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "PrintThread").start();
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName());
        currentThread.join(1000);
    }

    @Test
    public void testNewTheadObject() throws InterruptedException {
        final String[] names_1 = new String[10];
        final String[] names_2 = new String[10];
        new TestThread(names_1, 100).start();
        new TestThread(names_1, 100).start();

        List<String> list = Arrays.asList(names_1);
        for (String name : list) {
            System.out.println(name);
        }
        Thread.currentThread().join(3000);
    }

    @Test
    public void testThreadLocal() throws InterruptedException {
        List<String> books = Arrays.asList("A","B","C","D");
        new Thread(new Book("Ramayana", books)).start();
        new Thread(new Book("Mahabharata", books)).start();;
        Thread.currentThread().join(1000);
        System.out.println(books);
    }
    
    @Test
    public void testThreadLocalWithoutLocalThread() throws InterruptedException {
        List<String> chapters = new ArrayList<>(Arrays.asList("A","B","C"));
        new Thread(new BookWithoutThreadLocal("Ramayana", chapters)).start();
        new Thread(new BookWithoutThreadLocal("Mahabharata", chapters)).start();
        Thread.currentThread().join(1000);
        System.out.println(chapters);
    }

    class TestThread extends Thread {
        String[] names;
        long sleep;

        TestThread(String[] names, long sleep) {
            this.names = names;
            this.sleep = sleep;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            // int l = names.length == 0 ? 5 : names.length;
            for (int i = 0; i < names.length; i++) {
                names[i] = name + "-" + i;
            }

        }
    }

    public class Book implements Runnable {
        private final ThreadLocal<List<String>> WORDS = ThreadLocal.withInitial(ArrayList::new);

        private final String bookName; // It is also the thread's name
        private final List<String> words;

        public Book(String bookName, List<String> words) {
            this.bookName = bookName;
            this.words = Collections.unmodifiableList(words);
        }

        public void run() {
            WORDS.get().addAll(words);
            WORDS.get().add(bookName);
            System.out.printf("Result %s: '%s'.%n", bookName, String.join(", ", WORDS.get()));
        }

    }
    
    public class BookWithoutThreadLocal implements Runnable {
        
        private final String bookName; // It is also the thread's name
        private final List<String> words;

        public BookWithoutThreadLocal(String bookName, List<String> words) {
            this.bookName = bookName;
            this.words = words;
        }

        public void run() {
            words.add(bookName);
            System.out.printf("Result %s: '%s'.%n", bookName, String.join(", ", words));
        }

    }

}
