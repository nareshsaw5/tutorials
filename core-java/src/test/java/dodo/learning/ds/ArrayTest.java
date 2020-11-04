package dodo.learning.ds;

import java.util.Arrays;
import java.util.logging.Logger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ArrayTest {
   

    @Test
    public void testFindMaxInArray(){
        int[] ar = new int[] {2, 12, 5, 6, 8, 9, 8};
        int max = findMaxNumber(ar);
        System.out.println("Max "+ max);
        Assertions.assertEquals(12, max);
        int max2 = findMaxNumberWithLib(ar);
        System.out.println("Max with sort "+ max2);
        Assertions.assertEquals(12, max2);
    }
    
    @Test
    public void testFindMinInArray(){
        int[] ar = new int[] {2, 12, 5, 6, 8, 9, 8};
        int min = findMinNumber(ar);
        System.out.println("Min "+ min);
        Assertions.assertEquals(2, min);
    }
    
    @Test
    public void testSwapArray(){
        int[] ar = new int[] {1,2,3,4};
        int[] original = Arrays.copyOf(ar, ar.length);
        swapArray(ar);
        System.out.println(Arrays.toString(ar));
        Assertions.assertEquals(original, ar);
        
    }
    
    @Test
    public void testCopyArary() {
        int[] sourceAr =  new int[] {1,2,3,4,5};
        int[] destinationAr = new int[sourceAr.length];
        System.arraycopy(sourceAr, 2, destinationAr, 0, 2);
        System.out.println("tt"+Arrays.toString(destinationAr));
    }
    

    
    /**
     * This gives O(N) complexity
     * Find the max number in the array
     * @param ar
     */
    public int findMaxNumber(int[] ar) {
        int len = ar.length;
        if(len == 0) {
            return -1;
        }
        
        int max = ar[0];
        for(int i=1; i< ar.length; i++) {
            if(ar[i] > max) {
                max = ar[i];
            }
        }
        return max;
    }
    
    public int findMinNumber(int[] ar) {
        if(ar.length == 0) {
            return -1;
        }
        int min = ar[0];
        //iterate through whole array
        for(int n: ar) {
            if(n < min) {
                min = n;
            }
        }
        return min;
    }
    
    /**
     * This should give at least O(log N) complexity because of sort
     * Find the max number in the array
     * @param ar
     */
    public int findMaxNumberWithLib(int[] ar) {
        Arrays.sort(ar);
        return ar[ar.length-1];
    }
    
    /**
     * Swap the array, for input [1,2,3] <=> [3,2,1]
     * @param ar
     */
    public void swapArray(int[] ar) {
        int mid = (ar.length/2) + (ar.length % 2);
        int count=0;
        for(int i = 0, j = ar.length -1; i < ar.length ; i++, j--) {
            if(count == mid) {
                return;
            }
            int tmp = ar[i];
            ar[i] = ar[j];
            ar[j] = tmp;
            count++;
        }
    }

}
