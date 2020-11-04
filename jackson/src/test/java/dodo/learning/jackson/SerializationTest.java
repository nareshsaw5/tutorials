package dodo.learning.jackson;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dodo.learning.dto.Staff;

public class SerializationTest {

    private ObjectMapper mapper = null;

    @BeforeTest
    public void beforeTest() {
        mapper = new ObjectMapper();
    }

    @Test
    public void testSerialization() {
        Staff staff = new Staff();
        staff.setName("Naresh");
        staff.setAge(20);
        staff.setId(100);
        try {
            String serializedStaff = mapper.writeValueAsString(staff);
            System.out.println(serializedStaff);
            assertTrue(serializedStaff.contains("id"));
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testDeserialization() {
        String serializedString = "{\"id\":100,\"name\":\"Naresh\",\"age\":20}";
        try {
            Staff staff = mapper.readValue(serializedString, Staff.class);
            assertNotNull(staff.getAge());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
