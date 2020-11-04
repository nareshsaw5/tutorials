package com.dodo.tutorials.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortUtilTest {

    @Test public void testSelectionSort() {
        int[] ar = { 2, 3, 4, 1 };
        SortUtil.sort(ar);
        SortUtil.print(ar);
        Assertions.assertArrayEquals(new int[] { 1, 2, 3, 4 }, ar);
    }

    @Test public void testSelectionSort_2() {
        int[] ar = { 7, 3, 2, 1 };
        SortUtil.sort(ar);
        SortUtil.print(ar);
        Assertions.assertArrayEquals(new int[] { 1, 2, 3, 7 }, ar);
    }

    @Test public void testReverseRead() {
        int[] ar = { 7, 3, 2, 1 };
        SortUtil.reverseRead(ar);
    }

    @Test public void testSelectionSortReverse_1() {
        int[] ar = { 1, 3, 2, 7 };
        SortUtil.selectionSortWithReverseRead(ar);
        SortUtil.print(ar);
    }

    @Test public void testBubbleSort() {
        int[] ar = { 1, 3, 2, 7 };
        SortUtil.bubbleSort(ar);
//        SortUtil.print(ar);
    }

    @Test public void testInsertionSort() {
        int[] ar = { 2, 4, 3, 7 };
        SortUtil.insertionSort(ar);
        //        SortUtil.print(ar);
    }

    @Test public void testInsertionSort_2() {
        int[] ar = { 10, 2, 1, 4, 11, 3 };
        SortUtil.insertionSort(ar);
        //        SortUtil.print(ar);
    }

}
