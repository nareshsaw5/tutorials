package dodo.learning.ds.heap;

public class MinimumHeap<T extends Comparable<T>> extends Heap {
    
    @SuppressWarnings("unchecked")
    public MinimumHeap(Class<T> clazz) {
        super(clazz);
    }
    
    @SuppressWarnings("unchecked")
    public MinimumHeap(Class<T> clazz, int size) {
        super(clazz, size);
    }
    
    /**
     * Shift down to find the right place of the node which is wrong place
     * We continue to shit down until-unless, we find the right place for the node
     * @param index
     */
    public void shiftDown(int index) {
        int leftIndex = getLeftChildIndex(index);
        int rightIndex = getRightChildIndex(index);
        
        // find the minimum of the left and right elements.
        int smallerIndex = -1;
        if(leftIndex != -1 && rightIndex != -1) {
            smallerIndex = getElementAtIndex(leftIndex).compareTo(getElementAtIndex(rightIndex)) < 0
                    ? leftIndex : rightIndex; 
        }else if( leftIndex != -1) {
            smallerIndex = leftIndex;
        }else if( rightIndex != -1) {
            smallerIndex =  rightIndex;
        }
        
        //Compare the smaller child with the current index and if a swap 
        // is needed, then sift down if needed
        swap(smallerIndex, index);
        shiftDown(smallerIndex);
    }
    
    /**
     * Shift up
     * @param index
     */
    public void shiftUp(int index) {
        int parentIndex = getParentIndex(index);
        
        if(parentIndex != -1 && getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) < 0 ) {
                swap(parentIndex, index);
        }
    }

    public void insert(T value) throws HeapFullException {
        if(count >= array.length) {
            throw new HeapFullException("Heap is full");
        }
        array[count] = value; // append the value at the end
        shiftUp(count);
        count++;
    }
    
    /**
     * Its easy to get the highest priority as we need to get at the 0th one.
     * @return
     * @throws HeapEmptyException
     */
    public T getHighestPriority() throws HeapEmptyException{
        if(count == 0) {
            throw new HeapEmptyException("Heap is empty");
        }
        return (T) array[0];
    }
    
    /**
     * 
     * @return
     * @throws HeapEmptyException
     */
    public T removeHighestPriority() throws HeapEmptyException {
        T min = getHighestPriority();
        
        array[0] = array[count - 1];
        count--;
        shiftDown(0);
        return min;
    }
}
