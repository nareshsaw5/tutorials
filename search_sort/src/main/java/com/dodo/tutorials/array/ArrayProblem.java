package com.dodo.tutorials.array;

import java.util.*;

public class ArrayProblem {

    public static void main(String[] args) {
        int count = findMaxConsecutiveOnes(new int[] { 1, 1, 0, 0, 1, 1 });
        System.out.println(count);
        System.out.println("------------");
        int[] nums = new int[] { 1, 1, 1, 5, -2, 3, 2, 1 };
        int k = 3;
        int subArrayCount = findSubArrayOfGivenSum(nums, k);
        System.out.println(subArrayCount);
        System.out.println("------------");

        int evenNumberOfDigits = findNumbers(new int[] { 12, 345, 2, 6, 7896 });
        System.out.println(evenNumberOfDigits);

        System.out.println("------------");
        int[] ar = sortedSquares(new int[] { -4, -1, 0, 3, 10 });
        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }
        System.out.println("------------");
        int[] zeroArrays = new int[] { 1, 0, 1, 0 };
        duplicateZeros(zeroArrays);
        System.out.println("----------");

        int[] arr = new int[]{10,2,5,3};
        boolean exists = checkIfExist(arr);
        System.out.println(exists);
        System.out.println("----------");

        int[] arrMountain = new int[]{10,2,5,3};
        boolean isMountain = validMountainArray(arrMountain);
        System.out.println(isMountain);


    }

    /**
     * Replace Elements with Greatest Element on Right Side
     * Input: arr = [17,18,5,4,6,1]
     * Output: [18,6,6,6,1,-1]
     * @param arr
     * @return
     */
    public int[] replaceElements(int[] arr) {
        //array which will hold replaced elements
        int[] replaced = new int[arr.length];
        //current maximum values starts at -1
        int max = -1;

        //loop through each element
        for(int i = arr.length - 1; i >= 0; i--){
            //replace the current element
            replaced[i] = max;

            //if the current element is now greater than the max
            //set max to the current element
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return replaced;
    }

    /**
     * Valid Mountain Array
     *
     * Solution
     * Input: arr = [0,3,2,1]
     * Output: true
     * @param arr
     * @return
     */
    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;
        int start = 0;
        int end = arr.length-1;
        while (start < end) {
            if (arr[start+1] > arr[start]) {
                start++;
            } else if (arr[end-1] > arr[end]) {
                end--;
            } else {
                break;
            }
        }
        return start != 0 && end != arr.length-1 && start == end;
    }

    /**
     * Input: arr = [10,2,5,3]
     * Output: true
     * Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
     * @param arr
     * @return
     */
    public static boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int i:arr){
            if(set.contains(2*i) || (i%2==0 && set.contains(i/2))){
                return true;
            }
            set.add(i);
        }
        return false;
    }

    /**
     *
     * Input:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     *
     * Output: [1,2,2,3,5,6]
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = m; i < m + n; i++, j++) {
            nums1[i] = nums2[j];

        }
        Arrays.sort(nums1);
    }

    /**
     * @param arr
     */
    public static void duplicateZeros(int[] arr) {
        List<Integer> list = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                list.add(0);
                list.add(arr[i]);
            } else {
                list.add(arr[i]);
            }
        }
    }

    /**
     * Squares of a Sorted Array
     * Input: [-4,-1,0,3,10]
     * Output: [0,1,9,16,100]
     *
     * @param A
     * @return
     */

    public static int[] sortedSquares(int[] A) {
        int[] sortedArray = Arrays.stream(A).map(i -> i * i).sorted().boxed().mapToInt(i -> i).toArray();
        return sortedArray;

    }

    /**
     * Find Numbers with Even Number of Digits
     * Input: nums = [12,345,2,6,7896]
     * Output: 2
     * Explanation:
     * 12 contains 2 digits (even number of digits).
     * 345 contains 3 digits (odd number of digits).
     * 2 contains 1 digit (odd number of digits).
     * 6 contains 1 digit (odd number of digits).
     * 7896 contains 4 digits (even number of digits).
     * Therefore only 12 and 7896 contain an even number of digits.
     * <p>
     * Input: nums = [555,901,482,1771]
     * Output: 1
     * Explanation:
     * Only 1771 contains an even number of digits.
     *
     * @param nums
     * @return
     */
    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int x : nums) {
            StringBuilder sb = new StringBuilder().append(x);
            if (sb.length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * @param nums
     * @param k
     * @return
     */
    public static int findSubArrayOfGivenSum(int[] nums, int k) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }

            }

        }
        return count;

    }

    /**
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int windowSize = 0;
        int maxTillNow = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                windowSize++;
            } else {
                maxTillNow = Math.max(maxTillNow, windowSize);
                windowSize = 0;
            }
        }
        return (maxTillNow = Math.max(maxTillNow, windowSize));
    }
}
