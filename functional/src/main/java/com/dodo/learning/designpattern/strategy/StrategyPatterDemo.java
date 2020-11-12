package com.dodo.learning.designpattern.strategy;

import java.util.ArrayList;
import java.util.List;

public class StrategyPatterDemo {

    public static void main(String[] args) {

        List<Stock> list = new ArrayList<>();
        list.add(new Stock("Google", 100, 50));
        list.add(new Stock("Cisco", 20, 50));
        list.add(new Stock("Netapp", 10, 5));
        list.add(new Stock("Oracle", 30, 15));

        // ------ we don't need above function to filter data
        // instead pass pass the predicate
        // the function is written in such a way it
        // it choose different strategy

        StockFilters.filter(list, stock -> stock.getPrice() > 90).forEach(System.out::println);
        StockFilters.filter(list, stock -> stock.getSymbol().equals("Oracle") ).forEach(System.out::print);

    }
}
