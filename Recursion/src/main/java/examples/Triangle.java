package examples;

public class Triangle {

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
//        System.out.println(triangle.blocks(0) == 0);
//        System.out.println(triangle.blocks(1) == 1);
//        System.out.println(triangle.blocks(2) == 3);
//        System.out.println(triangle.blocks(3) == 6);
//        System.out.println(triangle.blocks(4) == 10);
        System.out.println(triangle.blocks(5) == 15);

    }

    public int blocks(int rows){
        if(rows == 0) {
            return 0;
        }else if(rows == 1){
            return 1;
        }else {
            int total = rows + blocks(rows-1);
            return total;
        }
    }
}
