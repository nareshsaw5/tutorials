package functional.constructor_ref;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Function<Runnable, Thread> threadGenerator = Thread::new;
        threadGenerator.apply( ()-> System.out.println("hello "+Thread.currentThread().getName())).start();

        StringBuilder sb = new StringBuilder();
        changeSb(sb);
        System.out.println(sb.toString());

    }

    public static String change(String s){
        s = s + s;
        System.out.println(s);
        return s;
    }


    public void changeObj(Object obj){
        System.out.println(obj);
        obj = new Object();
        System.out.println(obj);
    }

    public static void changeSb(StringBuilder sb){
        sb.append("Naresh");
    }


}
