package functional.function;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {
        Function<String, Boolean> isAnagramFn = (s) -> {
            return new StringBuilder(s).reverse().toString().equals(s);
        };
        List<String> names = Arrays.asList("Naresh", "Suresh", "Dinesh", "aba");
        Map map = createMap(names, isAnagramFn);
        System.out.println(map);
    }

    public static Map<String, Boolean> createMap(List<String> names, Function<String, Boolean> function) {
        Map<String, Boolean> mapOfAnagram = new Hashtable<>();
        for (String name : names) {
            mapOfAnagram.put(name, function.apply(name));
        }
        return mapOfAnagram;
    }
}
