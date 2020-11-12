package com.dodo.learning.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionDemo {

    public static void main(String[] args) {
        List<Integer>  list = Arrays.asList(1,2,3);
        Collections.shuffle(list);
        System.out.println(list);
    }
}
