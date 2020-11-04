package functional.generic;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class GenericFunctionalDemo {

    public static void main(String[] args) {
        GenericFunctional<String, String> gf = s -> s.substring(1,5);
        System.out.println(gf.execute("Naresh"));

        GenericFunctional<String, Integer> gf_1 = s -> s.length();
        System.out.println(gf_1.execute("Naresh"));

        GenericFunctional<Integer, Boolean> check_prime = n -> {
            for (int i = 2; i < n ; i++) {
                if(n % i == 0){
                    return false;
                }
            }
            return true;
        };

        System.out.println(check_prime.execute(3));
        System.out.println(check_prime.execute(5));
        System.out.println(check_prime.execute(4));
    }
}
