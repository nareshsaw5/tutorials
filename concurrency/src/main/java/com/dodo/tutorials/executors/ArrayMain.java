package com.dodo.tutorials.executors;

public class ArrayMain {

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 1, 1, 5, -2, 3, 2, 1 };
        int k = 3;

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length ; j++) {
                sum += nums[j];
                if(sum == k){
                    count++;
                }

            }

        }

        System.out.println(count);

    }
}
