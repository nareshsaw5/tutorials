package example.generic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {


    // without upper bound
    public static List<Integer> sort(List<Integer> list){
        list.sort(Comparator.naturalOrder());
        return list;
    }

    // without upper bound
    public static List<Character> sortCharacter(List<Character> list){
        list.sort(Comparator.naturalOrder());
        return list;
    }

    // with upper bound
    public static List<? extends Number> sortNumber(java.util.List<? extends Number> list){
        return list.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Character> list = Arrays.asList('a','c','b','d');
        sortCharacter(list);
        System.out.println(list);

        List<Integer> numbers = Arrays.asList(1,6,5,8,7);
        // This is problematic
//        List<Number> sorted = (List<Number>) sortNumber(numbers);
        List<Integer> sorted = sort(numbers);
        System.out.println(sorted);
    }
}
