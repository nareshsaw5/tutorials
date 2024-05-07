package example.defaults;

import java.util.List;

public interface Multiplier {

    int multiply(List<Integer> list);
    // this can be overridden
    default int size(List<Integer> list){
        return list.size();
    }
    default boolean isEmpty(List<Integer> list){
        return list.isEmpty();
    }
    // this can not be overridden
    static boolean isEmptyStatic(List<Integer> list){
        return list.isEmpty();
    }
}
