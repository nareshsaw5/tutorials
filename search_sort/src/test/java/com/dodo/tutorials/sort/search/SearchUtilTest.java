package com.dodo.tutorials.sort.search;

import com.dodo.tutorials.search.SearchUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchUtilTest {

    @Test void testBinarySearch() {

        int[] sortedList = {11, 22, 33, 44, 55, 66, 77, 88, 99, 110};
        int number = SearchUtil.binarySearch(sortedList, 44);
        Assertions.assertEquals(3, number);
        Assertions.assertEquals(-1, SearchUtil.binarySearch(sortedList, 45));
    }
}
