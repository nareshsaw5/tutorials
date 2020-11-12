package com.dodo.learnings.generics;


class BaseData<T> {

}


// lets make it generic as we are not able to pass any type of data as parameter in the constuctor
public class Data<T> extends BaseData<T> implements IData<T> {

    private T data;

    public Data() {
    }

    public Data(T data) {
        this.data = data;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override public String toString() {
        return "Data{" + "data=" + data + '}';
    }
}
