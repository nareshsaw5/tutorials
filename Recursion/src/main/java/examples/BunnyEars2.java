package examples;

public class BunnyEars2 {
    public static void main(String[] args) {

        // TODO Not passing
        BunnyEars2 bunnyEars2 = new BunnyEars2();
        System.out.println(bunnyEars2.bunnyEars(0) == 0);
        System.out.println(bunnyEars2.bunnyEars(1) == 2);
        System.out.println(bunnyEars2.bunnyEars(3) == 5);

    }

    /**
     *
     * @param bunnies
     * @return
     */
    public int bunnyEars(int bunnies){
        if(bunnies == 0){
            return 0;
        }else if( bunnies % 2 == 0){
            return 3 * bunnyEars( bunnies - 1);
        }else {
            return 2 * bunnies;
        }
    }
}
