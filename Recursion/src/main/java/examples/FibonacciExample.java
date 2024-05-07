package examples;


/**
 * The fibonacci sequence is a famous bit of mathematics,
 * and it happens to have a recursive definition.
 * The first two values in the sequence are 0 and 1 (essentially 2 base cases).
 * Each subsequent value is the sum of the previous two values,
 * so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
 * Define a recursive fibonacci(n) method that returns the nth fibonacci number, with n=0 representing the start of the sequence.
 *
 *
 * fibonacci(0) → 0
 * fibonacci(1) → 1
 * fibonacci(2) → 1
 */
public class FibonacciExample {

    public static void main(String[] args) {
        FibonacciExample example = new FibonacciExample();
        int n = 10; // Adjust the value of n as needed
        System.out.println("Fibonacci sequence up to " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            System.out.print(example.fibonacci(i) + " ");
        }
    }


    public int fibonacci(int n) {
        if(n == 0) {
            return 0;
        }else if(n == 1){
            return 1;
        }else {
            return  fibonacci(n-1) + fibonacci(n-2);
        }

    }
}
