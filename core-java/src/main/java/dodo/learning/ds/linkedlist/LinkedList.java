package dodo.learning.ds.linkedlist;

public class LinkedList<T extends Comparable<T>> implements Cloneable {
    
    private Node<T> head = null;
    
    /**
     * Getting count of the nodes in this Linked List
     * @return
     */
    public int getCount() {
        if(head == null) {
            return 0;
        }else {
            Node<T> curr = head;
            int counter = 0; 
            while( curr != null) {
                curr = curr.getNext();
                counter++;
            }
            return counter;
        }
    }
    
    /**
     * Add the node at the end of the linked list
     * @param data
     */
    public void addNode(T data) {
        if( head == null ) {
            head = new Node<T>(data);
        }else {
            // means there are elements in the linked list, hence find the last one
            Node<T> curr = head;
            while( curr != null) {
                curr = curr.getNext();
            }
            curr = new Node<T>(data);
        }
    }
    
   public T popElement() {
       if( head != null) {
           T popElement = head.getData();
           head = head.getNext();
           return popElement;
       }
       return null;
   }
}
