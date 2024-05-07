package example.defaults;

import java.util.Arrays;
import java.util.List;

public class MultiplierClient {

    public static void main(String[] args) {
        Multiplier multiplier = new MultiplierImpl();
        List<Integer> list = Arrays.asList(2,3,4,5,6);
        int v = multiplier.multiply(list);
        System.out.println(v);
        System.out.println("========");
        System.out.println("default method "+multiplier.size(list));
        System.out.println("default method "+multiplier.isEmpty(list));
        System.out.println("static method "+Multiplier.isEmptyStatic(list));
    }
}
