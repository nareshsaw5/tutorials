package com.dodo.tutorials.problem;

import java.util.*;

public class SumOf4 {

    private Hashtable table  = new Hashtable();
    public List<List<Integer>> fourSum(int[] nums, int target) {

        for (int i = 0; i < nums.length ; i++) {
            int sum = Integer.MAX_VALUE;
            for (int j = 1; j < nums.length ; j++) {
                sum = nums[i]+nums[j];
                if(sum == target){
                    String key = nums[i]+""+nums[j];
                    int[] tmpAr = new int[2];
                    tmpAr[0] = nums[i];
                    tmpAr[1] = nums[j];
                    table.put(key, tmpAr);
                }
            }
        }
        Enumeration enumeration = table.keys();
        List list = new ArrayList();
        while(enumeration.hasMoreElements()){
            list.add(Arrays.asList(table.get(enumeration.nextElement())));

        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        SumOf4 sumOf4 = new SumOf4();
        List subArrays = sumOf4.fourSum(nums, 0);
        for (int i = 0; i < subArrays.size(); i++) {
            List list = (List) subArrays.get(i);
            for (int j = 0; j < list.size(); j++) {
                int[] ar = (int[])list.get(j);
                for (int k = 0; k <ar.length ; k++) {
                    System.out.println(ar[k]);
                }
               ;
            }
            System.out.println("++++++");
        }
    }
}
