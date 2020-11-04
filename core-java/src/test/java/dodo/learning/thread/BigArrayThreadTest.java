package dodo.learning.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BigArrayThreadTest {
    
    @Test
    public void testMultiProcessingArray() throws InterruptedException {
        List<Integer> ar = new ArrayList(Arrays.asList("0","1","2","3","4","5","6","7","8","9","10","11","12","13")); 
        System.out.println(ar.size());
        int divisor = 5; 
        int division = ar.size()/divisor;
        System.out.println(division);
        int start=0; int end = 0;
        for(int i=0; i< division; i++) {
            end = start + divisor;
            end = end > ar.size() ? ar.size()-1 : end;
            System.out.println(start);
            System.out.println(end);
            new ArrayIncrementThread(""+i, ar, start, end).start();
            start = end + 1;
        }
        Thread.currentThread().join(1000);
        System.out.println(ar);
    }
    
}

class ArrayIncrementThread extends Thread {
    
    List<Integer> list;
    String name;
    int startIndex;
    int endIndex;
    
    ArrayIncrementThread(String name, List<Integer> ar, int startIndex, int endIndex){
        this.name = name;
        this.list = ar;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
    
    @SuppressWarnings("boxing")
    @Override
    public void run() {
       
        if(list != null && list.size() > 0) {
            int i = this.startIndex > -1 ? this.startIndex : 0;
            int j = this.endIndex > 0 ? this.endIndex : 0;
            for(; i <= j ; i++) {
                //int v = Integer.parseInt(list.get(i))+20;
                Integer v = new Integer(i+20);
                list.set(i, v);
            }
        }
    }
    
}
