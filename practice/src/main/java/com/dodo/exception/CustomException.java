package com.dodo.exception;

public class CustomException  extends Exception{

    public CustomException(){
        super();
    }

    public CustomException(Throwable e){
        super(e);
    }

    public CustomException(String message){
        super(message);
    }
}
