package com.dodo.tutorials.search;

public class SearchUtil {

    /**
     *
     * @param sortedList
     * @param number
     * @return
     */
    public static int binarySearch(int[] sortedList, int number){
       int min = 0;
       int max = sortedList.length - 1;

       while(min <= max) {

           int mid = (min + max)/2;
           if (sortedList[mid] == number) {
               // return the index of the number being searched in the sortedList or sorted array
               return mid;
           }
           if (sortedList[mid] > number) {
               // look in the left the mid number is greater than the number being searched
               max = mid - 1;
           } else {
               // look in right as mid number is smaller than the number being searched
               min = mid + 1;
           }
       }

        return -1;
    }
}
