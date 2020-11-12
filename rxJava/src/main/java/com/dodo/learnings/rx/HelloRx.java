package com.dodo.learnings.rx;

import io.reactivex.rxjava3.core.Observable;

public class HelloRx {

    public static void main(String[] args) {

        // keep observers
        Observable<Object> source = Observable.create(e -> {
            e.onNext("Hello");
            e.onNext("Rx");
        });


        // this is one of ther observer, when the even is generated
        source.subscribe( e -> System.out.println("Observer 1 "+e));
        source.subscribe( e -> System.out.println("Observer2 " +e));
    }
}
