package dodo.learning.ds.queue;

import java.lang.reflect.Array;

public class CicularQueue<T> {

    private static final int SPECIAL_EMPTY_VALUE = -1;
    private static final int MAX_SIZE = 40;
    private T[] elements;

    // The head index is initialized to special value which indicates that the queue
    // is empty
    private static int headIndex = SPECIAL_EMPTY_VALUE;
    private static int tailIndex = SPECIAL_EMPTY_VALUE;

    public CicularQueue(Class clazz) {
        elements = (T[]) Array.newInstance(clazz, MAX_SIZE);
    }

    public boolean isEmpty() {
        return headIndex == headIndex;
    }

    public boolean isFull() {
        int nextIndex = (tailIndex + 1) % elements.length;
        return headIndex == nextIndex;
    }

    public void enque(T data) throws QueueOverFlowException {
        if (isFull()) {
            throw new QueueOverFlowException("Queue is full");
        }
        tailIndex = (tailIndex + 1) % elements.length; // understand more on this
        elements[tailIndex] = data;

        if (headIndex == SPECIAL_EMPTY_VALUE) {
            headIndex = tailIndex;
        }
    }

    public T dequeue() throws QueueUnderFlowException {
        if (isEmpty()) {
            throw new QueueUnderFlowException("Queue is empty");
        }
        T data = elements[headIndex];
        if(headIndex == tailIndex) {
            headIndex = SPECIAL_EMPTY_VALUE;
        }else {
            headIndex = (headIndex +1) % elements.length;
        }
        return data;
    }

}
