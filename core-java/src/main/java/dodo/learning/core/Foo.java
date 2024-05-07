package dodo.learning.core;

public class Foo {

    Count count ;

    static {
        System.out.println("Foo static initializer");
    }

    {
        count =  new Count();
        System.out.println("instance initializer block " + count.getCounter());
    }

    Foo() {
        System.out.println("Foo constructor");
    }

    public int getCount() {
        return count.getCounter();
    }

    public static class Count {

        private int counter = 0;

        void increment() {
            ++counter;
        }

        void decrement() {
            ++counter;
        }

        public int getCounter() {
            return counter;
        }
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
    }



}
