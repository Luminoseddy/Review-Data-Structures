package linkedlist;

/* 
 * Generic class, holds any data type.
 * Should be comparable for equality checks to do things like 
 *  find what index a particular E is located in the list. 
 */

public class Node<T extends Comparable<T>> {
    /* Info within any Node is the DATA and a reference to the next NODE */
    private T data;
    private Node<T> next;

    /* Constructor takes in DATA associated with this NODE 
     * setNext is set to null initially. 
     **/
    public Node(T data) {
        this.data = data;
        setNext(null);
    }

   
    /* GETTERS AND SETTERS FOR THE DATA AND THE NEXT REFERENCE 
     * getNext() Returns the next node after this node.
     **/
    public Node<T> getNext() {
        return next;
    }
    /* setNext() Sets the next node after this node. */
    public void setNext(Node<T> next) {
        this.next = next;
    }
    
    public T getData() {
        return data;
    }
    
    
    
    
    /* THE STRING REPRESENTATION OF THE NODE IS SIMPLY THE STRING REPRESENTATION OF THE DATA STORED IN THE NODE */
    @Override
    public String toString() {
        return String.valueOf(data);
    }
}


    
