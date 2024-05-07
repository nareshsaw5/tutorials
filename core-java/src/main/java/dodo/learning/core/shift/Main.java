package dodo.learning.core.shift;

public class Main {

    public static void main(String[] args) {
        int a = 5;
        int a1 = 7 >> 1; // should be 2, it's divided by 2 to the power 1;
        System.out.println(a1);

        int b = 10;
        System.out.println(10 >> 1); // should be 5

        int c = 40;
        System.out.println(40 >> 2); // should be 10, being divided by 2 to the power 2

        int d = 80;
        System.out.println(80 >> 3); // should be 10;

        System.out.println("---------------------");

        int x = 5;
        System.out.println(a << 1); // should be 10 as it will be multiplied by 2 to the power 1;

        int y = 256;
        System.out.println(y >>> 8); // should be 1;

        int z = 10 << 2; // should be 40
        System.out.println(z);



    }
}
