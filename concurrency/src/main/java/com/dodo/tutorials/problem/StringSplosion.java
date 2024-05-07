package com.dodo.tutorials.problem;

public class StringSplosion {
    public static void main(String[] args) {
        String s = stringSplosion("Code");
        System.out.println(s);
    }

    public static String stringSplosion(String str) {
        int l = str.length();
        String result = "";
        for(int i=0; i <= l; i++){
            String v = str.substring(0, i);
            result += v;
        }

        return result;
    }

}
