package com.dodo.tutorials.stack;

public class Stack {

    int size = 10;
    int currentIndex = 0;
    Object[] elements;

    Stack(){
        elements = new Object[size];
    }

    public Stack(int size) {
        this.size = size;
        elements = new Object[size];
    }

    public void push(Object object){
        this.elements[currentIndex] = object;
        currentIndex++;
    }

    public Object pop(){
        Object obj = this.elements[currentIndex-1];
        currentIndex--;
        return obj;
    }

    public static void main(String[] args) {
        Stack myStack = new Stack(6);
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(40);
        myStack.push(50);
        for (int i = 0; i < myStack.size-1 ; i++) {
            System.out.println(myStack.pop());
        }
    }

}
