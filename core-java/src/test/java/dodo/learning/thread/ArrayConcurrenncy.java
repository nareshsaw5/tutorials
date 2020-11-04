package dodo.learning.thread;

public class ArrayConcurrenncy {

    public static void main(String[] arg) {
        final int[] ar = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        System.out.println("before");
        print(ar);
        new Thread(new ModifyArray(ar)).start();
        new Thread(new ModifyArray(ar)).start();
        System.out.println("-----------");
        System.out.println("after");
        print(ar);
    }

    static void print(int[] ar) {
        for(int i=0; i< ar.length; i++) {
            System.out.println(ar[i]);
        }
    }

}

class ModifyArray implements Runnable {

    int[] array;

    ModifyArray(int[] array) {
        this.array = array;
    }

    public void run() {
        for (int i = 0; i < array.length; i++) {
            array[i] = ArrayUtils.increment(array[i]);
            System.out.println(Thread.currentThread().getName() + ", " + array[i]);
        }
    }
}

class ArrayUtils {
    public static synchronized int increment(int i) {
        return i = i+10;
    }
}
