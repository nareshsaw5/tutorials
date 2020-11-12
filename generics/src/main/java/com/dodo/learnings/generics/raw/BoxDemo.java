package com.dodo.learnings.generics.raw;

import java.util.List;

public class BoxDemo {

    public static void main(String[] args) {

        Box<Integer> box = new Box<>(List.of(1, 2, 3, 4, 5));

        for (Integer v : box.getA()) {

            System.out.println(v);
        }
    }
}
