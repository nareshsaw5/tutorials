package dodo.learning.dto.mapping;

import java.util.Set;

public class Product {

    private int id;
    private String serialNumber;
    private Set<Order> orders;
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    void setSerialNumber(String sn) {
        serialNumber = sn;
    }

}
