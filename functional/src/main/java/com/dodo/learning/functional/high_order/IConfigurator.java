package com.dodo.learning.functional.high_order;

@FunctionalInterface
public interface IConfigurator<T, R> {

    R configure(T t);
}
