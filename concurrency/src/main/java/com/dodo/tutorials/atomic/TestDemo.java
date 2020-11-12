package com.dodo.tutorials.atomic;

import java.util.ArrayList;

public class TestDemo {

    public static void main(String[] args) {

        int[] N = new int[]{3, 5, 6, 3, 2}; //
        int counter = 0 ;
        int min = N[0];
        for (int i = 0; i < N.length ; i++) {
            counter++;
            if(N[i] < min){
                min = N[i];
            }
        }
        System.out.println(counter);
        System.out.println(min);
}


    public static long permutationOf(int N) {
        long total = (N * (N-1))/2;
        if(total > 1000000000){
            total = 1000000000;
        }
        return total;
    }

    public void test(String S) {

        String curr = "";
        ArrayList<String> uqStrings = new ArrayList<String>();
        ArrayList<String> visited = new ArrayList<String>();

        for (int i = 1; i < S.length(); i++) {
            for (int j = 0; j < S.length() - i + 1; j++) {
                curr = S.substring(j, j + i);
                if (!visited.contains(curr)) {
                    uqStrings.add(curr);
                    visited.add(curr);
                } else {
                    uqStrings.remove(curr);
                }
            }

            if (!uqStrings.isEmpty())
                break;
            visited.clear();
        }
        String result = "";
        for (String s : uqStrings)
        {
            result = s;
        }
        System.out.println(result.length());

    }



    }
