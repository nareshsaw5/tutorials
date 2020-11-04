package dodo.learning.ds.stack;

public class Element<T> {
    
    private T data;
    private Element<T> next;
    
    public Element(T data, Element<T> nextElement) {
        this.data = data;
        this.next = nextElement;
    }
    
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public Element getNext() {
        return next;
    }
    public void setNext(Element next) {
        this.next = next;
    }
    
    

}
