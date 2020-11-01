package com.dodo.tutorials.datastructure.queue;

import java.lang.reflect.Array;

/**
 * The Queue follows FIFO patterns
 * It dequeue/removes/poll elements from the head/front, need special attention as array offers pop() from end,
 * we need to dequeue/poll from front.
 * It enqueue/adds/offer elements at the back
 * This implementation is array based, hence adding/enqueue is always at end hence no need to take additional step
 * @param <T>
 */
public class ArrayQueue<T> {

    private static final int SPECIAL_EMPTY_VALUE = -1 ;
    private T[] elements;
    private int MAX_SIZE = 40;
    private int headIndex = 0;
    private int tailIndex = SPECIAL_EMPTY_VALUE;
    private int size = 0;

    public ArrayQueue(Class clazz) {
        this.elements = (T[])Array.newInstance(clazz, MAX_SIZE);
    }

    public void enqueue(T data){
        elements[++tailIndex] = data;
        size++;
    }

    /**
     * This comes from Collection interface
     * For a capacity-constrained queue,
     * the difference is that add() always returns true and throws an exception if it can't add the element
     * @param data
     */
    private void add(T data){
        // throws exception if it can not add
        enqueue(data);
    }

    /**
     * This comes from Queue interface
     *
     * @param data
     */
    public boolean offer(T data){
        // return false if it can not add
        if(tailIndex == elements.length){
            return false;
        }
        enqueue(data);
        return true;
    }

    public int size(){
        return size;
    }

    public T poll(){
        T element = elements[headIndex];
        headIndex++;
        size--;
        return element;
    }
}
