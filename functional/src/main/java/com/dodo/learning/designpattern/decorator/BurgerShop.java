package com.dodo.learning.designpattern.decorator;

import java.util.function.Function;

/**
 * This shop creates variety of Burgurs
 * Following Decorator pattern
 */

public class BurgerShop {

    Function<Burger, Burger> decorators;

    public BurgerShop(Function<Burger, Burger> decorators) {
        this.decorators = decorators;
    }

    public Burger use(Burger baseBurger){
        System.out.println("Base burger "+baseBurger);
        return decorators.apply(baseBurger);
    }


}
