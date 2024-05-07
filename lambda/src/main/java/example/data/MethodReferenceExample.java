package example.data;

import java.util.function.Function;

public class MethodReferenceExample {
    static Function<String, String> toUpperCaseLambda = (s) -> s.toUpperCase();
    static Function<String, String> toUpperCaseLambdaMethodRef = String::toUpperCase;
    public static void main(String[] args) {
        System.out.println(toUpperCaseLambda.apply("java8"));
        System.out.println(toUpperCaseLambdaMethodRef.apply("java8"));

    }
}
