package dodo.learning.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class EqualTest {
    
    
    @Test
    public void testEmpty() {
        String a = null;
        String b = null;
        
        boolean checkA = check(a);
        boolean checkB = check(b);

        Assertions.assertEquals(false, (check(a) && check(b)));
        
    }
    
    private boolean check(String a) {
        // isEmpty check for null and ""
        //return (!StringUtils.isEmpty(a) && !"null".equals(a));
        return false;
    }
    
    
    @Test
    public void testList() {
        List<String> names = new ArrayList<>();
        names.add("Naresh");
        names.add("Suresh");
        System.out.println(names);
        
        List<String> names_2  = Arrays.asList("Naresh","Suresh","Dinesh");
        System.out.println(names_2);
        
    }

}
