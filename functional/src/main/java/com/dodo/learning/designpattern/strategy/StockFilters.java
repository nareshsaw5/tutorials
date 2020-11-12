package com.dodo.learning.designpattern.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StockFilters {

    public static List<Stock> filter(List<Stock> stocks, Predicate<Stock> predicate) {

        List<Stock> filteredData = new ArrayList<>();

        for (Stock stock : stocks) {
            if(predicate.test(stock)){
                filteredData.add(stock);
            }

        }
        return filteredData;

    }

}
