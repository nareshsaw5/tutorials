package example.defaults;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultMethodExample {

    public static void main(String[] args) {

        /**
         * sort the list in alphabetical order
         */
        List<String> list = Arrays.asList("Adam","Jenny","Alex","Dan","Mike", "Eric");

        // before java 8
        //Collections.sort(list);
        //System.out.println("sorted before 8 "+list);

        // java 8 onwards
        List<String> sorted = list.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sorted);
        // another way
        list.sort(Comparator.naturalOrder());
        System.out.println("sorted after 8 "+list);
        list.sort(Comparator.reverseOrder());
        System.out.println("reverse sort after 8 "+list);
    }
}
