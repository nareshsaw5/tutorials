package example.functionalnterfaces;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

    static Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
    public static void main(String[] args) {
        BinaryOperator<Integer> binaryOperator = (a, b) -> a*b;
        System.out.println(binaryOperator.apply(2,3));

        System.out.println(BinaryOperator.maxBy(comparator).apply(10,11));
        System.out.println(BinaryOperator.minBy(comparator).apply(10,11));
    }
}
