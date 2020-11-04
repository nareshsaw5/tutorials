package dodo.learning.udemy.thread;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ComplexCalculationTest {
    
    public static void main(String[] arg) throws InterruptedException {
        BigInteger r = calculateResult(BigInteger.valueOf(10L), BigInteger.valueOf(4L), BigInteger.valueOf(20L), BigInteger.valueOf(4L));
        System.out.println("in main "+r);
    }

    public static BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) throws InterruptedException {
        BigInteger result = BigInteger.ZERO;
        /*
         * Calculate result = ( base1 ^ power1 ) + (base2 ^ power2). Where each
         * calculation in (..) is calculated on a different thread
         */
        List<PowerCalculatingThread> threadList = new ArrayList<>();
        threadList.add(new PowerCalculatingThread(base1, power1));
        threadList.add(new PowerCalculatingThread(base2, power2));
        
        for(Thread t: threadList) {
            t.start();
        }
        
        for(Thread t: threadList) {
            t.join(200);
        }
        
        for(PowerCalculatingThread t: threadList) {
            result = result.add(t.getResult());
        }
        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            /*
             * Implement the calculation of result = base ^ power
             * 
             */
            Double r = Math.pow(base.doubleValue(), power.doubleValue());
            result = BigInteger.valueOf(r.longValue());
            System.out.println(result);
        }

        public BigInteger getResult() {
            return result;
        }
        
        
    }

}
