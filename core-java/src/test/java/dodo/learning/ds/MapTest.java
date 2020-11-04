package dodo.learning.ds;

import org.junit.jupiter.api.Test;

import java.util.Hashtable;
import java.util.Map;



public class MapTest {
    
    @Test
    public void testHashtable() {
        
        Map<String, Integer> map = new Hashtable();
        map.put("One", 1);
        map.put("Hundred", 100);
        map.put("TwoHundred", 200);
        System.out.println(map);
        
    }

}
