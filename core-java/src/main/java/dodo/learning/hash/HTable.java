package dodo.learning.hash;

import java.util.ArrayList;
import java.util.List;

public class HTable {

    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    List<String> list = new ArrayList<>();

    public HTable() {
    }

    public HTable(int value, List<String> list) {
        this.value = value;
        this.list = list;
    }

    public List<String> getList(){
        return this.list;
    }

    public boolean add(String str){
        return this.list.add(str);
    }

    public boolean remove(String str){
        return this.list.remove(str);
    }
}
