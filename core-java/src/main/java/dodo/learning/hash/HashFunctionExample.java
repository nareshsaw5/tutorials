package dodo.learning.hash;

public class HashFunctionExample {

    public static void main(String[] args) {
        String naresh = "Naresh";
        String suresh = "Suresh";

        int hash_naresh = naresh.hashCode();
        int hash_suresh = suresh.hashCode();

        // -1968815077
        //-1807198902
        //
        System.out.println(hash_naresh);
        int adjustedHashCode = hash_naresh ^ (hash_naresh >>> 16); // Bitwise adjustment
        System.out.println(adjustedHashCode);

    }
}
