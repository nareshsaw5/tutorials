package functional;

public class Main {

    public static void main(String[] args) {

        MyFunctionalInterface fn = () -> System.out.println("Hello Naresh");
        fn.sayHello();

        // Let us call testFunction by passing the behaviour
        testFunction(  () -> System.out.println("Hi! How are you doing"));

        Name nameFn = () -> System.out.println("Hey John");
        nameFn.myName();

        int x = 6;
        int y = 5;
        Calc addFn  = (a, b) -> a + b;
        int sum = addFn.compute(x,y);
        System.out.println(sum);

        Calc subFn = (a, b) -> a - b;
        int sub = subFn.compute(x, y);
        System.out.println(sub);

        Calc mul = (a, b) -> a * b;
        int m = mul.compute(x,y);
        System.out.println(m);



    }

    public static void testFunction(MyFunctionalInterface fn){
        fn.sayHello();
    }
}
