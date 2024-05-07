package dodo.learning.hash;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class MyHashTable {

    int clusterSize = 3;

    List<HTable> hashTable = new ArrayList(clusterSize);

    public MyHashTable() {
        for (int i = 0; i <clusterSize ; i++) {
            hashTable.add(new HTable());
        }
    }

    public int hash(String server) {
        int hash = 0;
        char[] chars = server.toCharArray();
        int PRIME = 39;
        for (int i = 0; i <chars.length ; i++) {
            char c = chars[i];
            // Get the position of character in alphabetical order by substracting 96
            int position = Character.hashCode(c) - 96;
            hash = (hash * PRIME + position)%clusterSize;
//            System.out.println(hash);
        }
        return hash;
    }

    public void add(String str){
        int hash = this.hash(str);
        HTable table = this.hashTable.get(hash);
        table.setValue(hash);
        table.getList().add(str);
    }

    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append("[");
        for (int i = 0; i <hashTable.size() ; i++) {
            HTable table = hashTable.get(i);
            output.append(table.getValue()+": {");
            List<String> list = table.getList();
            for (int j = 0; j <list.size() ; j++) {
                output.append(list.get(j)+",");
            }
            output.append("} ");
        }
        output.append("]");
        return output.toString();
    }

    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable();
        hashTable.add("a");
        hashTable.add("b");
        hashTable.add("aa");
        hashTable.add("bb");
        hashTable.add("ff");
        hashTable.add("gg");
        hashTable.add("dd");
        System.out.println(hashTable);

        Hashtable<String, String> hashtable = new Hashtable<>();
       // System.out.println(hashtable);

        String s1 = "Naresh";
        String s2= "Naresh";
        String s3 = new String("Naresh");
        String s4 = new String("Naresh");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s3==s4);
    }

}
