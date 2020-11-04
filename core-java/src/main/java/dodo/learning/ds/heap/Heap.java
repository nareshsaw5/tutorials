package dodo.learning.ds.heap;

import java.lang.reflect.Array;

public class Heap<T extends Comparable<T>> {
    
    private static final int MAX_SIZE = 40;
    protected T[] array;
    protected int count;
    
    public Heap(Class<T> clazz){
        this(clazz, MAX_SIZE);
    }
    
    
    @SuppressWarnings("unchecked")
    public Heap(Class<T> clazz, int size) {
        array = (T[]) Array.newInstance(clazz, size);
    }
    
    /**
     * Get the left child index with formula as 2i + 1;
     * @param index
     * @return
     */
    public int getLeftChildIndex(int index) {
        int leftChildIndex = 2 * index + 1;
        if(leftChildIndex >= count) {
            return -1;
        }
        return leftChildIndex;
    }
    
    /**
     * Get rightChild index with formula 2i+ 2
     * @param index
     * @return
     */
    public int getRightChildIndex(int index) {
        int rightChildIndex = 2 * index + 2;
        if(rightChildIndex >= count) {
            return -1;
        }
        return rightChildIndex;
        
    }
    
    
    /**
     * Get the parent index with formula (i-1)/2
     * @param index
     * @return
     */
    public int getParentIndex(int index) {
        if(index < 0 || index > count) {
            return -1;
        }
        int parentIndex = (index - 1) / 2;
        return parentIndex;
    }
    
    /**
     * Swap the value at two indexes in array
     * @param index1
     * @param index2
     */
    public void swap(int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == array.length;
    }
    
    public int getCount() {
        return count;
    }
    
    public T getElementAtIndex(int index) {
        return array[index];
    }
    
}
