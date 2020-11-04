package dodo.learning.ds.stack;

/**
 * This min stack returns min value in constant time O(1) Typically, the getMin
 * of any stack is O(N) as we will have to traverse N time of time to get the
 * min value in the stack. But with this implementation, the space is not a
 * constraint, hence we are maintaining two stack so that getMin has always time
 * complexity as O(1) Lets look at the implementation
 * 
 * @author nsaw
 * @param <E>
 *
 */
public class MinimumStack<E> {

    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> minimumStack = new Stack<Integer>();

    public int getMinimum() throws StackUnderFlowException {
        return minimumStack.peek();
    }

    public void push(int data) throws StackOverFlowException, StackUnderFlowException {
        if (stack.isFull()) {
            throw new StackOverFlowException("Stack is full");
        }
        int min = data;
        if (!minimumStack.isEmpty()) {
            if (min > minimumStack.peek()) {
                min = minimumStack.peek();
            }
        }
        minimumStack.push(min);
        stack.push(data);
    }
    
    public int pop() throws StackUnderFlowException {
        minimumStack.pop();
        return stack.pop();
    }

}
