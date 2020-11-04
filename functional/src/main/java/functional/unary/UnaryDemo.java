package functional.unary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;

public class UnaryDemo {

    public static void main(String[] args) {

        UnaryOperator<Integer> squareFn = (i) -> i * i;

        Map sqMap = squareMap(Arrays.asList(1,2,3,4,5), squareFn);
        System.out.println(sqMap);

    }

    static Map<Integer, Integer> squareMap(List<Integer> list, UnaryOperator<Integer> sqFn) {
        Map<Integer, Integer> sqMap = new HashMap<>();

        for (Integer v : list) {
            sqMap.put(v, sqFn.apply(v));
        }
        return sqMap;

    }
}
