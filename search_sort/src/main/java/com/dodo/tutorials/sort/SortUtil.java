package com.dodo.tutorials.sort;

public class SortUtil {

    /**
     * Selection sort is the most basic sort
     * It compares each item with all other item to sort an array
     * uses nested loop to do the comparison
     * It has order of n*n O(n*n) of complexity in worst case
     * @param arToSort
     * @return
     */
    public static int[] sort(int[] arToSort){

        for (int i = 0; i < arToSort.length ; i++) {

            for (int j = i + 1; j <= arToSort.length-1; j++) {
                if(arToSort[i] > arToSort[j]){
                    swap(arToSort, i, j);
                }
            }
        }
        return arToSort;
    }

    /**
     * Swap the value/position in array with two indexes
     * It uses O(n) for swapping in worst case.
     * @param arToSort
     * @param iIndex
     * @param jIndex
     */
    private static void swap(int[] arToSort, int iIndex, int jIndex){
        int tmp = arToSort[iIndex];
        arToSort[iIndex] = arToSort[jIndex];
        arToSort[jIndex] = tmp;
    }

    /**
     * Print array
     * @param arToSort
     */
    public static void print(int[] arToSort){

        for (int i = 0; i < arToSort.length ; i++) {
            System.out.println(arToSort[i]);
        }
    }

    /**
     * In backward read, you can only start from arrayLength -1 and go till 0.
     * @param ar
     */
    public static void reverseRead(int[] ar){
        for (int i = ar.length-1; i >= 0 ; i--) {
            System.out.println(ar[i]);
        }
    }

    /**
     *
     * @param arToSort
     * @return
     */
    public static int[] selectionSortWithReverseRead(int[] arToSort){

        for (int i = arToSort.length - 1; i >= 0  ; i--) {
            for (int j = i-1; j >= 0; j--) {
                if(arToSort[i] > arToSort[j]){
                    swap(arToSort, i, j);
                }
            }

        }
        return arToSort;
    }

    /**
     * Bubble sort is adaptive and may break the loop early
     * so on average, it gives better performance
     * although worst case is same and it gives O(n*n)
     * It is a stable sort
     * It makes O(n*n) comparison and O(n*n) swap as well
     *
     * @param arToSort
     * @return
     */
    public static int[] bubbleSort(int[] arToSort){

        for (int i = 0; i <arToSort.length ; i++) {
            boolean swapped = false;
            for (int j = arToSort.length - 1; j > i; j--) {
                // compare with adjacent element
                if(arToSort[j] < arToSort[j-1]){
                    swap(arToSort, j, j-1);
                    swapped = true;
                }
            }
            print(arToSort);
            // if the nested loop is not swapped even once during comparison, means the array is sorted, hence break it
            if(!swapped){
                break;
            }
        }
        return arToSort;
    }

    /**
     *
     * Its very similar to Bubble Sort
     * BUBBLE SORT REQUIRES AN ADDITIONAL PASS OVER ALL ELEMENTS TO ENSURE THAT THE LIST IS FULLY SORTED
     * BUBBLE SORT HAS TO DO N COMPARISONS AT EVERY STEP. INSERTION SORT CAN STOP COMPARISON ELEMENTS WHEN THE RIGHT POSITION IN THE SORTED LIST IS FOUND
     * BUBBLE SORT PERFORMS POORLY WITH MODERN HARDWARE BECAUSE OF THE NUMBER OF WRITES AND SWAPS THAT IT PERFORMS. RESULTS IN CACHE MISSES SO HAS GREATER OVERHEAD THAN INSERTION SORT
     * @param listToSort
     * @return
     */
    public static int[] insertionSort(int[] listToSort){

        for (int i = 0; i < listToSort.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (listToSort[j] < listToSort[j - 1]) {
                    swap(listToSort, j, j - 1);
                } else {
                    break;
                }
                print(listToSort);
                System.out.println("-----");
            }
        }
        return listToSort;
    }

    public void merge(int[] ar1, int[] ar2){

    }
    /**
     * This function split an array into two
     * @param arToSort
     */
    public void split(int[] arToSort){
        int min = 0;
        int max = arToSort.length-1;
        int mid = (min + max)/2;
        if(arToSort.length == 1){
            return ;
        }
        int[] leftArray = new int[mid];
        int[] rightArray = new int[arToSort.length - (mid+1)];
        for(int a: leftArray){
            System.out.println(a);
        }
        for(int b: rightArray){
            //SortUtil
        }
        split(leftArray);
        split(rightArray);
    }

    /**
     * TODO Test it
     * @param ar
     */
    public void split_working(int[] ar) {

        if(ar.length == 1) {
            return;
        }

        int mid = (ar.length/2 + ar.length%2);
        int[] left = new int[mid];
        int[] right = new int[ar.length - mid];
        int i = 0;
        while(i < mid) {
            left[i] = ar[i];
            i++;
        }
        i = 0 ;
        int k = mid;
        while(k < ar.length) {
            right[i] = ar[k];
            i++;
            k++;
        }
        System.out.println("********************");
        print(left);
        System.out.println("-------");
        print(right);
        System.out.println("********************");
        //---- recurse ------
        split(left);
        split(right);

    }


}
