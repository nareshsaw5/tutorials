package example.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamMinMaxExample {

    static Optional<Integer> max(List<Integer> list){
        return list.stream()
                .reduce((a, b) -> a > b ? a: b);
    }

    static Optional<Integer> min(List<Integer> list){
        return list.stream()
                .reduce((a, b) -> a > b ? b: a);
    }
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(7,2,3,5,6);
        int max = max(list).get();
        System.out.println(max);
        int min = min(list).get();
        System.out.println(min);

        System.out.println("=========");
        Optional<Integer> minOptional = min(new ArrayList<>());
        if(minOptional.isPresent()) {
            System.out.println(minOptional.get());
        }

    }
}
