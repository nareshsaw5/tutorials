package dodo.learning.ds.stack;

public class Stack<T> {
    
    private static final int MAX_SIZE = 40;
    private Element<T> top;
    private int size;
    
    public void push(T data) throws StackOverFlowException {
        if (size == MAX_SIZE) {
            throw new StackOverFlowException("Stack is full");
        }
        Element<T> e = new Element<T>(data, top);
        top = e;
        size++;
    }
    
    public T pop() throws StackUnderFlowException {
        if(size ==0) {
            throw new StackUnderFlowException("Stack is empty");
        }
        // get the data from top
        T data = top.getData();
        // make sure, change the reference of top to the next element
        top = top.getNext();
        // decrease the size;
        size--;
        return data;
    }
    
    public T peek() throws StackUnderFlowException{
        if (size == 0) {
            throw new StackUnderFlowException("Statck is empty");
        }
        return top.getData();
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == MAX_SIZE;
    }
    
    public int getSize() {
        return size;
    }
    
    
    
    
    

}
