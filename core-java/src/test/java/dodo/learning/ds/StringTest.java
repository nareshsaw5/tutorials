package dodo.learning.ds;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;


public class StringTest {
    
    @Test
    public void testDuplicate() {
        
        String s = "Nareshsh";
        // printDuplicate(s);
        // System.out.println(isAnagram("Keep", "Peek"));
        // System.out.println(isAnagram("Mother","Father"));
        s = "naresh";
        //reverseString(s);
        System.out.println(reverse2(s));
        
    }
    
    private void printDuplicate(String s) {
        char[] characters = s.toCharArray();
        Map<Character, Integer> map = new Hashtable<>();
        for(char c: characters) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }else {
                map.put(c, 1);
            }
        }
        
        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        for(Map.Entry<Character, Integer> entry: entrySet) {
            if(entry.getValue() > 1) {
                System.out.printf("%s : %d %n", entry.getKey(), entry.getValue());
            }
        }
    }
    
    private boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        
        char[] first = s1.toLowerCase().toCharArray();
        char[] second = s2.toLowerCase().toCharArray();
        
        Arrays.sort(first);
        Arrays.sort(second);
        
        return Arrays.equals(first, second);
    }
    
    public String reverseString(String str) {
      //base case to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
  }
    
    public String reverse2(String s) {
        StringBuilder sb = new StringBuilder();
        char[] ar = s.toCharArray();
        
        for(int i= ar.length-1 ;i >= 0; i --) {
            sb.append(ar[i]);
        }
        return sb.toString();
    }
    
    public boolean isAnagram_2(String s1, String s2) {
        String revers = reverse2(s1);
        return Arrays.equals(s2.toCharArray(), revers.toCharArray());
    }

}
