package com.dodo.exception;

public class MainException {


    public static void main(String[] args) {
        try {
            extracted();
        }catch (CustomException e){
            e.printStackTrace();
            System.out.printf(e.getMessage());
        }

    }

    private static void extracted() throws CustomException  {
        String s ="";
        try {
            s.substring(2);
        }catch (IndexOutOfBoundsException e){
            throw new CustomException(e);
        }
    }
}
