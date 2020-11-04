package dodo.learning.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class Child extends Parent {

    private int count;

    static {
        System.out.println("Child staitic iniitizer");
    }

    {
        System.out.println("Child instance initializer");
    }

    Child() {
        System.out.println("Child constructor with loader " + Child.class.getClassLoader());
    }

    Child(String name) {
        super(name);
        System.out.println(" Child overloaded constructor " + name);
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Queue<Integer> q = new ArrayDeque<>();
        for(int i =0; i < 10; i++){
            q.add(i);
        }
        ((ArrayDeque<Integer>) q).addFirst(10);
        ((ArrayDeque<Integer>) q).addLast(12);
        Iterator forwardItr = q.iterator();
        while(forwardItr.hasNext()){
            System.out.println(forwardItr.next());
        }

    }
}
