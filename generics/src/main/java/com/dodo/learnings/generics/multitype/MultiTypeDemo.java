package com.dodo.learnings.generics.multitype;

public class MultiTypeDemo {

    public static void main(String[] args) {
        Bin<String,Integer> bin = new Bin();
        bin.setWetWaste("gsghsgl");
        bin.setDryWaste(123);
        System.out.println(bin);
    }
}
