package com.dodo.learning.functional.high_order;

public class HigherOrderMain {

    public static void main(String[] args) {

        IFactory<Integer> createFactory = createFactory( () -> Math.random()*100, r -> r.intValue());
        Integer finishedProduct = createFactory.create();
        System.out.println(finishedProduct);

    }


    public static <T, R> IFactory<R> createFactory(IProducer<T> producer, IConfigurator<T, R> configurator){

        return () -> {
            T product = producer.produce();
            return configurator.configure(product);
        };
    }
}
