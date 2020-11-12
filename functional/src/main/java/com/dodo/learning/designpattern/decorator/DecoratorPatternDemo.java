package com.dodo.learning.designpattern.decorator;

public class DecoratorPatternDemo {

    public static void main(String[] args) {
        // In decorator pattern, we add/modify capability(decorate) in the object at run time, rather than
        // design time.

        //In older way we had to add lot of function in a given class
        // or have different implementation fot the same class to add dynamic
        // behaviour in object

        Burger myBuger = new BurgerShop((burger) -> burger.addVegies()).use(new Burger());
        System.out.println(" I got  " + myBuger);

        Burger cheeseBurger = new BurgerShop((burger) -> burger.addVegies())
                .use(new BurgerShop((burger) -> burger.addCheese()).use(new Burger()));
        System.out.println(" I got  " + cheeseBurger);

    }
}
