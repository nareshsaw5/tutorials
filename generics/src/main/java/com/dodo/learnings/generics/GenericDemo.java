package com.dodo.learnings.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo {

    public static void main(String[] args) {
        System.out.println(GenericMethodUtil.concat(12.4));
        System.out.println(GenericMethodUtil.concat(12345));


        // accepts Number of subclass of Number
        List<Number> list = new ArrayList<>();
        Number n  = 12;
        list.add(n);
        list.add(12);
    }
}
