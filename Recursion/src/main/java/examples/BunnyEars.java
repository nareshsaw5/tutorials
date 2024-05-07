package examples;

public class BunnyEars {


    /**
     *
     We have a number of bunnies and each bunny has two big floppy ears. We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).
     bunnyEars(0) → 0
     bunnyEars(1) → 2
     bunnyEars(2) → 4
     */

    public static void main(String[] args) {
        BunnyEars bunnyEars = new BunnyEars();

        int ears = bunnyEars.bunnyEars(1);
        System.out.println(bunnyEars.bunnyEars(1) == 2);
        System.out.println(bunnyEars.bunnyEars(2) == 4);
        System.out.println(bunnyEars.bunnyEars(3) == 6);
        System.out.println(bunnyEars.bunnyEars(4) == 8);
    }

    public int bunnyEars(int bunnies) {
        if(bunnies == 0){
            return 0;
        }else {
            return 2 * bunnies;
        }
    }

}
