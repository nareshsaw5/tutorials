package dodo.learning;

public class SuperClass {
    
    public SuperClass() {
        System.out.println("super class constructor");
    }
    
    
    public void test() {
        System.out.println("test in superclass");
    }

    public static void main(String[] args) {
        Product p = new Product();
        p.testA();
    }
}


interface I1 {
    default void testA(){
        System.out.println("Inteface I1.A");
    }
}


interface I2 {

    void testA();
}

class Product implements I1, I2 {

    @Override public void testA() {
        System.out.println("Product.testA");
    }
}
