package com.dodo.learnings.generics;


interface Interface1<T> {

}

interface Interface2<Integer> {

}

class Parent implements Interface2 {}


public class SubclassDemo<T> extends Parent implements Interface1<T>  {

    public static void main(String[] args) {

    }
}
