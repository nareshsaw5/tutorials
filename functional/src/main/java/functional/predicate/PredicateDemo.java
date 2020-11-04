package functional.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Naresh", "", "suresh", "");
        Predicate<String> pr = s -> !s.isEmpty();
        for (String name: names){
            if(pr.test(name)){
                System.out.println("Non empty "+name);
            }
        }
        Predicate<String> isAnagram = s -> {
            StringBuilder sb = new StringBuilder(s);
            String rev = sb.reverse().toString();
            return rev.equals(s);
        };
        System.out.println(isAnagram.test("aba"));

        Predicate<Integer> isPrime = (N) -> {
            for (int i = 2; i <N ; i++) {
                if(N % i == 0){
                    return false;
                }

            }
            return true;
        };
        System.out.println(isPrime.test(3));

        String name = "This is my name. Naresh";
        Predicate<String> hasName = (s) -> s.contains("Naresh");
        System.out.println(hasName.test(name));
    }
}
