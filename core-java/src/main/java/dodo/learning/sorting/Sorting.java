package dodo.learning.sorting;

/**
 * Selection Sort implementation
 * @author nsaw
 *
 */
public class Sorting {
    
    
    public void print(int[] ar) {
        for(int i=0; i< ar.length; i++) {
            System.out.println("Element : "+ar[i]);
        }
    }
    
    /**
     * swapping function
     * @param ar
     * @param iIndex
     * @param jIndex
     */
    public void swap(int[] ar, int iIndex, int jIndex) {
        int temp = ar[iIndex];
        ar[iIndex] = ar[jIndex];
        ar[jIndex] =  temp;
    }
    
    /**
     * This is a basic sort where two loops are iterated 
     * and each element is compared against N-1 elements
     * The time complexity is O(NxN) and swap has complexity as O(N)
     * @param ar
     */
    public void selectionSort(int[] ar) {
        for(int i=0; i<ar.length; i++) {
            for(int j= i+1; i<ar.length ; j++) {
                if(ar[i] > ar[j]) {
                    swap(ar, i, j);
                    print(ar);
                }
            }
        }
    }
    
    /**
     * There is no performance gain in bubble sort.
     * It has same time complexity (O(NxN)) as in selection sort
     * The swap is also O(NxN)
     * But it is adaptive means the loop may break early, based on input array
     * @param ar
     */
    public void bubbleSort(int[] ar) {
        for(int i=0; i< ar.length; i++) {
            boolean swapped = false;
            for(int j = ar.length -1; j > i; j--) {
                if(ar[j] > ar[j-1]) {
                    swap(ar, j, j-1);
                    swapped = true;
                }
            }
            print(ar);
            if(!swapped) {
                break;
            }
           
        }
    }
    
    
    public void insertionSort(int[] ar) {
        for(int i=0; i< ar.length; i++) {
            
            //start from adjacent element of i index and compare 
            //and swap till the first one(i.e. till 0th index)
            // it is comparing the elements in backward direction instead of forward
            // so each iteration of i, we will have a sorted sub-list (sub set of the list)
            for(int j = i+1; j > 0 ; j--) {
                if(ar[j] > ar[j-1]) {
                    swap(ar, j, j-1);
                }else {
                    break;
                }
                
            }
            print(ar);
        }
    }
  
    public void split(int[] ar) {
        
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
