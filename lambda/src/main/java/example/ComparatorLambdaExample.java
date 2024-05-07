package example;

import java.util.Comparator;

public class ComparatorLambdaExample {
    public static void main(String[] args) {
        Comparator comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator.compare(2,3));

        // functional way
        Comparator<Integer> lambdaComparator = (a, b) -> a.compareTo(b);

        System.out.println(lambdaComparator.compare(2,3));
    }
}
