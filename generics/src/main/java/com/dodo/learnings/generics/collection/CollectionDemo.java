package com.dodo.learnings.generics.collection;

import java.util.ArrayList;
import java.util.List;

public class CollectionDemo {

    public static void main(String[] args) {
        List list = new ArrayList();

        list.add(1);
        list.add("Naresh");

        for (Object ob : list) {
            System.out.println(ob);

        }
    }
}
