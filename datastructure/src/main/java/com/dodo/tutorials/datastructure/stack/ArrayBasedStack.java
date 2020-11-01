package com.dodo.tutorials.datastructure.stack;

import java.lang.reflect.Array;

public class ArrayBasedStack<T> {

    private T[] elements;
    private int MAX_SIZE = 40;
    private  int topIndex = -1;
    private int size = 0;

    public ArrayBasedStack(Class clazz) {
        this.elements = (T[])Array.newInstance(clazz, MAX_SIZE);
    }

    public void push(T data) throws StackOverflowError{
        if(topIndex == MAX_SIZE){
            throw new StackOverflowError("Stack is full");
        }
        elements[++topIndex] = data;
        size++;
    }

    public T pop(){
        if(topIndex == -1){
            System.out.println("Stack is empty");
            return null;
        }
        T data = elements[topIndex];
        topIndex--;
        size--;
        return data;
    }

    public int size(){
        return size;
    }

    public boolean isFull(){
        return size == MAX_SIZE;
    }

    public boolean isEmpty(){
        return size == 0;
    }

}
