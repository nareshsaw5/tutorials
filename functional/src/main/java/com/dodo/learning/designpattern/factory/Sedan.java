package com.dodo.learning.designpattern.factory;

public class Sedan implements Car{

    public int seats(){
        return 5;
    }

    public String type(){
        return "Sedan";
    }
}
