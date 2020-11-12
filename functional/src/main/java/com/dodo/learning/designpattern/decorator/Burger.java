package com.dodo.learning.designpattern.decorator;

public class Burger {

    private String burgerType;

    public Burger(){
        this.burgerType = "";
    }

    private Burger(String type){
        this.burgerType = type;
    }

    public Burger addVegies(){
        System.out.println("Adding vegies to the burger");
        return new Burger(this.burgerType += "Vegies");
    }

    public Burger addCheese(){
        System.out.println("Adding cheese to the burger");
        return new Burger(this.burgerType += "Cheese");
    }

    @Override public String toString() {
        return "Burger{" + "burgerType='" + burgerType + '\'' + '}';
    }
}
