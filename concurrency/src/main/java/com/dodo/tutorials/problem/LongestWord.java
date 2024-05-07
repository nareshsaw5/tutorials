package com.dodo.tutorials.problem;

public class LongestWord {
    public static String LongestWord(String sen) {
        // code goes here
        String[] sp = sen.split(" ");
        String longestString = sp[0];
        int maxLength = longestString.length();
        for (int i = 0; i < sp.length; i++) {
            if(sp[i].length() > maxLength){
                maxLength = sp[i].length();
                longestString = sp[i];
            };
        }
        return longestString;
    }

    public static void main(String[] args) {
        System.out.println(LongestWord("fun&!! time"));
    }
}
