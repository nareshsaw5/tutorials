package com.dodo.learnings.generics;


interface IBase<T> {}

public interface IData<T> extends IBase<T> {

    T getData();

    void setData(T data);
}
