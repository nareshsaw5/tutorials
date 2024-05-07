package example.numericstream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamMapExample {

    // convert and return list of int to list of Integer
    // similar to this we have mapToLong and mapToDouble
    static List<Integer> mapToObject(){
        return IntStream.rangeClosed(1,10)
                .mapToObj(i -> new Integer((i)))
                .collect(Collectors.toList());
    }

    static Double mapToDouble(){
        return IntStream.rangeClosed(1,10)
                .mapToDouble(i -> Double.valueOf((i)))
                .sum();
    }
    public static void main(String[] args) {

        System.out.println(mapToObject());
        System.out.println(mapToDouble());

    }
}
