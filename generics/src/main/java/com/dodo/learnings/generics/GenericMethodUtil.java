package com.dodo.learnings.generics;

public class GenericMethodUtil {


    /**
     * To make the method as generic, we need to put <T> before the return type</T>
     * @param data
     * @param <T>
     * @return
     */
    public static <T extends  Number> String concat(T data){
        return "Hello "+data;
    }


}
