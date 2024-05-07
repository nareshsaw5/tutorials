package dodo.learning.hash;

public class BitwiseExample {
    public static void main(String[] args) {
        int a = 5; // 0101 in binary
        int b = 3; // 0011 in binary

        int bitwiseAnd = a & b;
        int bitwiseOr = a | b;
        int bitwiseXor = a ^ b;
        int bitwiseNotA = ~a;
        int leftShiftA = a << 2; // Shift left by 2 positions

        System.out.println("Bitwise AND: " + bitwiseAnd);
        System.out.println("Bitwise OR: " + bitwiseOr);
        System.out.println("Bitwise XOR: " + bitwiseXor);
        System.out.println("Bitwise NOT of A: " + bitwiseNotA);
        System.out.println("Left Shift of A: " + leftShiftA);
    }
}
