package com.dodo.learning.functional.chaining;

import java.util.Objects;

@FunctionalInterface
public interface Consumer<T> {

    void accept(T t);

    default Consumer<T> acceptAndReturn(Consumer<T> next){
        Objects.requireNonNull(next);
        return (t) -> {
            accept(t);
            next.accept(t);
        };
    }
}
