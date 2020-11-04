package dodo.learning.ds;

import org.junit.jupiter.api.Test;


public class ComplexityFundementalTest {
    
    @Test
    public void testComplexity() {
        simpleFunction(2);
        simpleFunction(5);
        simpleFunction(10);
        
    }
    
    /**
     * Since all the operation within the function are almost treat as constant, increase/decrease in the number of 
     * n will not have any impact on the performance of the code
     * So the time complexity of this code is O(1) or Oder of 1 and it is constant
     * @param n
     */
    private static void simpleFunction(int n) {
        System.out.println("input "+n);
        long start  = System.currentTimeMillis();
        int a = 9;
        int b = 3;
        int sum = a + b + n;
        int product = a * b * n;
        int quotient = a * n/b;
        System.out.println(String.format("The sume is %s. The product is %s. The qutient is %s", sum, product, quotient));
        long end = System.currentTimeMillis();
        long timeTaken = end - start;
        System.out.println("Timetake "+timeTaken);
    }
    
    /**
     * The performance of this function depends on the size of input n
     * Hence the time complexity of the function has to be Order of N or O(N)
     * @param n
     */
    private void simpleForLoop(int n) {
        for( int i = 0; i < n; i++) {
            System.out.println(String.format("Square of %s is %s ", n, Math.pow(i, 2.0)));
        }
    }
  
    /**
     * This is same as simpleForLoop as the code is dependent on the size of input
     * So the time complexity will be again order of n or O(N)
     * Hence the time complexity will increase linearly 
     * If the value of n doubles, the code will take roughly twice as long
     * @param n
     */
    private  void simpleWhile(int n) {
        int i = 0;
        while (i > n) {
            System.out.println(String.format("Square of %s is %s ", n, Math.pow(i, 2.0)));
            i++;
        }
    }
    
    /**
     * The time complexity is always measured on worst case scenario.
     * 
     * In this function, we assume the the input is odd and hence it goes in else condition and executes for loop.
     * The time complexity of for loop is order of N or O(N)
     * @param n
     */
    private void testIfFunction(int n) {
        if (n % 2 == 0) {
            System.out.println("The input is even");
        }else {
            for (int i = 0 ; i < n; i++ ) {
                System.out.println(String.format("Square of %s is %s ", n, Math.pow(i, 2.0)));
            }
        }
    }
    
    /**
     * In this function, we are executing two for loops on input n.
     * As the time complexity of one for loop is O(N), then the complexity of this function would be
     * O(N2). 
     * @param n
     */
    private void nestedLoop(int n) {
        for(int i=0; i < n ;i ++) {
            for(int j = 0 ; j < n ; j++) {
                System.out.println(String.format("Square of %s is %s ", n, Math.pow(i, 2.0)));
            }
            
        }
    }
    
    /**
     * In this case, there are two loops, hence the time complexity is additive
     * and it is O(N+M)
     * @param n
     * @param m
     */
    private void twoLoop(int n, int m) {
        for(int i=0 ;i <n ; i++) {
            System.out.println(String.format("Square of %s is %s ", n, Math.pow(i, 2.0)));
        }
        for(int i=0 ;i <m ; i++) {
            System.out.println(String.format("Square of %s is %s ", m, Math.pow(i, 2.0)));
        }
    }
    
    /**
     * In this case, the the complexity will be O(N*M)
     * @param n
     * @param m
     */
    private void twoLoopMultiplication(int n, int m) {
        for(int i=0 ;i <n ; i++) {
            for(int j=0 ;j <m ; j++) {
                System.out.println("printing "+ (i*j));
            }
        }
    }
    
    /**
     * In this function, on each iteration, the value of i is doubled
     * 1st - i = 1 * 2 = 2
     * 2nd - i = 2 * 2 = 4
     * 3rd - i = 4 * 2 = 8
     * 4th - i = 8 * 2 = 16
     * So the formula 
     * 2 to the power k = N
     * at that point, we will break this loop
     * 2 to power of k = N
     * so the complexity with log of base 2 will be O(log N)
     * 
 
     * @param n
     */
    private void doublingLoopVariable(int n) {
        for(int i=1 ;i < n;) {
            System.out.println("Value of i "+ i);
            // lets double i
            i = i * 2;
        }
    }
    
    /**
     * In this function, we are halving i on each iteration
     * @param n
     */
    private void halvingLoopVariable(int n) {
        for(int i=n ;i > 0; ) {
            System.out.println("Value of i "+ i);
            i = i / 2;
        }
    }

}
