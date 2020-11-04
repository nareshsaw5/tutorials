package dodo.learning.searching;

public class BinarySearch {

    public int binarySearch(int[] sortedList, int key) {

        int min = 0;
        int max = sortedList.length;

        while (max > min) {
            int mid = (min + max) / 2;
            if (sortedList[mid] == key) {
                return mid;
            }
            if (sortedList[mid] > key) {
                // look in left side
                max = mid - 1;
            } else {
             // look in right side
                min = mid + 1;
            }
        }

        return -1;
    }

}
