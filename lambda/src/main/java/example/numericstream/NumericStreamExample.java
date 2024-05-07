package example.numericstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NumericStreamExample {


    // older way
    static Integer sum(List<Integer> input){
        return input.stream().reduce(0, (x,y) -> x+y);
    }

    // with numeric stream
    static int sum(){
        return IntStream.rangeClosed(1, 6)
                .sum();
    }


    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1,2,3,4,5,6);
        System.out.println(sum(input));
        System.out.println("==================");
        System.out.println(sum());
    }
}
