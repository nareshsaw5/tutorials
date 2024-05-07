package com.dodo.tutorials.problem;

public class BlackJack {

    public static int blackjack(int a, int b) {
        if(a > b && a > 21){
            return Math.min(a, b);
        }
        return  Math.min(a, b);
    }

    public static void main(String[] args) {
        blackjack(19,22);
    }

}
