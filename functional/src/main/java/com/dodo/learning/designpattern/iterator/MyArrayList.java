package com.dodo.learning.designpattern.iterator;

import java.util.function.Consumer;

public class MyArrayList<T> {

    Object[] elements = new Object[10];

    public MyArrayList(Object[] elements) {
        this.elements = elements;
    }

    public void forEach(Consumer<T> consumer){

        for (int i = 0; i < elements.length; i++) {
            consumer.accept((T)elements[i]);
        }
    }

}
