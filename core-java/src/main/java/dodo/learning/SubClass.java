package dodo.learning;

public class SubClass extends SuperClass {
    
    public SubClass() {
        System.out.println("sub class constructor");
    }
    
    @Override
    public void test() {
        super.test();
        System.out.println("test in subclass");
    }


}
