package dodo.learning.mockito;


import dodo.learning.SubClass;
import org.junit.jupiter.api.Test;

public class InheritanceTest {
    
    
    @Test
    public void testSuperSub() {
        SubClass _sub = new SubClass();
        _sub.test();
    }

}
