package example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamLimitAndSkipExample {

    /**
     * Only consider first 3 elements in the list
     * @param list
     * @return
     */
    static Optional<Integer> limit(List<Integer> list){
        return list.stream()
                .limit(3)
                .reduce( (a,b) -> a+b);
    }

    /**
     * Skip first 3 elements in the list
     * @param list
     * @return
     */
    static Optional<Integer> skip(List<Integer> list){
        return list.stream()
                .skip(3)
                .reduce( (a,b) -> a+b);
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,3,4,5,6,7);
        Optional<Integer> limitSum = limit(list);
        System.out.println(limitSum.get());
        System.out.println("=========");
        Optional<Integer> skipSum = skip(list);
        System.out.println(skipSum.get());
    }
}
