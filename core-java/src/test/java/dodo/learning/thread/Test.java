package dodo.learning.thread;

import java.util.stream.IntStream;

public class Test {
    
    public static void main(String[] arg) {
        Employee emp = new Employee();
        String s = "Naresh";
       
    }

}

class Account {
    protected int salary = 5000;
}

class Employee extends Account {
    int bonus = 6000;
    String name;
    
    public IntStream getSalary() {
        return name.chars();
    }
}


