package example.numericstream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamBoxingUnboxingExample {

    // return boxed elements as Integer from int
    static List<Integer> boxing(){
        return IntStream.rangeClosed(1,6)
                .boxed()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(boxing());
    }
}
