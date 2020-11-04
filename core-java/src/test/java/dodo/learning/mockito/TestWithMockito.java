package dodo.learning.mockito;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

public class TestWithMockito {
    
    
    // mock creation
    List mockedList = mock(List.class);

    @BeforeEach
    public void setup() {
     // stubbing appears before the actual execution
        when(mockedList.get(0)).thenReturn("first");
    }
    
    @Test
    public void testAdd() {
        System.out.println(mockedList.get(0));
    }
    
    
    @AfterEach
    public void tearDown() {
        mockedList.clear();
    }
    

}
