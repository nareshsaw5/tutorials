package com.dodo.tutorials.datastructure.stack;

public class Stack<T> {

    private Element top;
    private int size;


    public void push(T data){
        Element e = new Element(data, top);
        top = e;
        size++;
    }

    public T pop(){
        T data  = (T)top.getData();
        top = top.getNext();
        size--;
        return data;
    }

    public T peek(){
        return (T)top.getData();
    }

    public int size(){
        return size;
    }

}
