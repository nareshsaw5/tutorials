package com.dodo.tutorials.problem;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableProblem {
    public static int singleNumber(int[] nums) {
        // solve with frequence counter
        int count=0;
        Hashtable<Integer, Integer> table = new Hashtable();
        Integer foundItem = null;
        for(int i=0;i<nums.length;i++){
            count = 0;
            int item = nums[i];
            if(table.containsKey(item)){
                count = table.get(item);
                count++;
                table.put(nums[i], count);
            }else {
                count++;
                table.put(nums[i], count);
            }
        }

        Enumeration<Integer> keys = table.keys();
        while(keys.hasMoreElements()){
            Integer key = keys.nextElement();
            Integer objCount = table.get(key);

            if(objCount == 1){
                foundItem = key;
            }
        }
        return foundItem;
    }

    public static void main(String[] args) {
        int[] ar = new int[]{2,2,1};
        Integer item =singleNumber(ar);
        System.out.println(item);
    }

}
