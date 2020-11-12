package com.dodo.learning.functional.high_order;

@FunctionalInterface
public interface IFactory<T> {

    T create();

}
