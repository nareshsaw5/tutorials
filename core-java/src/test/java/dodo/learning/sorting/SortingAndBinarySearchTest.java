package dodo.learning.sorting;

import dodo.learning.searching.BinarySearch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortingAndBinarySearchTest {

    Sorting sort;
    BinarySearch binarySearch;

    @BeforeEach
    public void start() {
        sort = new Sorting();
        binarySearch = new BinarySearch();
    }

    @Test
    public void testDivide_ar() {
        int[] ar = { 1, 5, 3, 10, 6, 7 };
        // sort.split(ar);
    }

    @Test
    public void testBinarySearch() {
        int[] ar = new int[]{1,2,3,4,5,6,7,8};
        int foundIndex = binarySearch.binarySearch(ar, 7);
        if(foundIndex > -1) {
            System.out.println(String.format("Found value %s at %s ",ar[foundIndex], foundIndex));
        }
        
        
    }

}
