package example.stream;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamOfGenerateIterateExample {

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("a","b","c");
        stringStream.forEach(System.out::println);
        System.out.println("---------------");
        // if you don't give the limit, it will be infinite
        Stream.iterate(1, i-> i*2)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("---------------");
        // generate example
        Supplier<Integer> integerSupplier  = new Random()::nextInt;
        Stream.generate(integerSupplier)
                .limit(10)
                .forEach(System.out::println);

    }
}
