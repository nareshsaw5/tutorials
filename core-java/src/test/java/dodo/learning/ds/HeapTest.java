package dodo.learning.ds;

import java.util.Arrays;


import dodo.learning.ds.heap.Heap;
import org.junit.jupiter.api.Test;

public class HeapTest {

    @Test
    public void test() {
        Heap<Integer> heap = new Heap<>(Integer.class);

        int[] ar = new int[] { 1, 2, 3, 4, 9, 8 };
        int missingNumber = getMissingNumber(ar, 10);
        System.out.println(missingNumber);
        reverse(ar);
    }

    /**
     * Java method to find missing number in array of size n containing numbers from
     * 1 to n only. can be used to find missing elements on integer array of numbers
     * from 1 to 100 or 1 - 1000
     */
    private static int getMissingNumber(int[] numbers, int totalCount) {
        int expectedSum = totalCount * ((totalCount + 1) / 2);
        int actualSum = 0;
        for (int i : numbers) {
            actualSum += i;
        }

        return expectedSum - actualSum;
    }

    public static void reverse(int[] arr) {
        int size = (arr.length) / 2;
        int count = 0;

        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            count++;
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            if (count == size)
                break;
        }
        System.out.println(Arrays.toString(arr));
    }

}
