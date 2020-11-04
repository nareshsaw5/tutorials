package dodo.learning.core;

public class Parent {

    private String name;
    private int x;
    private int y;
    private int sum;

    static {
        System.out.println("Parent static initializer");
    }

    {
        System.out.println("Parent instance initializer");
    }

    Parent() {
        System.out.println("Parent constructor");
    }

    Parent(String s) {
        name = s;
        System.out.println("Parent overloaded constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void compute() throws Throwable {
        sum = x + y;
    }
}
