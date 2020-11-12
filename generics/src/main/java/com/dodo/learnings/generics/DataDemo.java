package com.dodo.learnings.generics;

public class DataDemo {

    public static void main(String[] args) {

        Data<String> dataS = new Data<>("Naresh");
        System.out.println(dataS.toString());

        IData<Integer> dataT = new Data<>(10);
        System.out.println(dataT);

        IData<Long> dataL = new Data<>(20L);
        System.out.println(dataL.toString());

        IBase<Double> dataD = new Data<>(20.00);
        System.out.println("double data "+dataD.toString());

        BaseData<Double> dataDD = new Data<>(20.00);
        System.out.println("double data "+dataDD.toString());

    }
}
