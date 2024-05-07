package com.dodo.tutorials.problem;

public class LastTwo {
    public static int last2(String str) {
        int l = str.length();
        int count = 0;

        for(int i=0; i<l-2; i+=2){
            if(i+2 < l) {
                String s = str.substring(i, i+2);
                System.out.println(s);
            }
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int count = last2("hixxhi");
        System.out.println(count);
        System.out.println("++++");
        count = last2("xaxxaxaxx");
        System.out.println(count);
    }
}
