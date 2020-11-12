package com.dodo.learning.functional.splititerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class CharacteristicDemo {

    public static void main(String[] args) {
        List<String> names = List.of("Naresh","Suresh","Dinesh", "XX","YY");
        Spliterator<String> spliterator = names.spliterator();
        int bits = spliterator.characteristics();
        System.out.println(Integer.bitCount(bits));

    }
}
