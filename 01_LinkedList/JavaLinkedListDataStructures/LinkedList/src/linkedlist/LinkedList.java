package linkedlist;

import java.util.ArrayList;
import java.util.List;

/** NOTES:LinkList are List data structures. 
 * 
 * Each E is linked to or references to the next E. (chaining)
 * Access LinkedList via the 1st E: 'head'.
 **/



/* A LINKED LIST CLASS HOLDS THE HEAD OF THE LINKED LIST - THIS CAN HOLD ALL THE METHODS WHICH OPERATE ON THE LIST */
public class LinkedList<T extends Comparable<T>> implements Cloneable {

    private Node<T> head = null; /* Initially, head is null. As nodes are created, the head referneces to the first E in the list. */

    /* Constructor. */
    public LinkedList() {}
 
    /* Complexity O(N) */
    /* Function appends a new node to the end of the linked list. */
    public void addNode(T data) {
        if (head == null) {                  /* If the head points to null, then the new added node is the new head. */
            head = new Node<T>(data);
        } else {
            Node<T> curr = head;             /* Class Node of dataType T is set to a variable curr, = new head */
            while (curr.getNext() != null) { /* Assuming its pointing at head. Loop through the list till we find a null. */
                curr = curr.getNext(); 
            }
            curr.setNext(new Node<T>(data)); /*  Create new node and point the last E to it. Recall that setNext was set to null in the constructor. */ 
        }
    }
    
    
    
    
    
    
    
    
    /* Return the first element in the linked list. */  
    public T popElement() {
        /* IF there are nodes in the linkList, access the 1st E via head reference. */
        if (head != null) { 
            T topElement = head.getData();  /* Access the top E, store it. */
            head = head.getNext();          /* Move the head pointer to ref. the next E. */
            return topElement;              /* Return the top element. */
        }
        return null;                        /* If head is null, it means is empty. return null. */
    }

    
    
    
    
    /* Print all the nodes in the linked list. */
    public void printNodes() {
     if (head  == null) {
         System.out.println("There is no node in the linked list");
     } else {
         Node<T> curr = head;
         int i = 1;
         System.out.print("LinkedList: ");
         while (curr != null) {
             System.out.print(curr.toString() + " ");
             curr = curr.getNext();
             i++;
         }
         System.out.print("\n");
     }
    }

    
    
    
    /* Count the number of nodes in the linked list.
     * Every time we traverse through the list in the while loop, set a counter i++. 
     **/
    public int countNodes() {
        if (head  == null) {
           return  0;
        } else {
            Node<T> curr = head;
            int count = 0;
            while (curr != null) {
                curr = curr.getNext();
                count++;
            }
            return count;
        }
    }

    
    
    /** 
     * Delete all the elements in the linked list.
     * No clean up required. Java's garbage collector will clean up the memory
     * for all the elements being used in this linked list if
     * they are no longer referenced in the program. 
     **/
    public void deleteLinkedList() {
        head = null;
    }

    
    
    
    
    /**
     * Insert at the nth position in the list. Return if the number of nodes is less than n.
     */
    public void insertNth(int n, T data) {
        if (n > countNodes()) { /* If n > than number of nodes. */
            return;
        }
        if (n == 0) {
            /* To insert at the 0th position update the head itself. */
            Node<T> nextNode = head;
            head = new Node<>(data);
            head.setNext(nextNode);
        } else {
            /* Move the curr node to one before the position where we want to insert the element and adjust the pointers accordingly. */    
            int i = 0;                /* Start i @ index 0 */
            Node<T> curr = head;      /* Set curr to point to head. */
            while (i < n - 1) {       /* Because we are using an arrayType index, we must - 1 */
                curr = curr.getNext();/* Traverse to the next node in the linkedlist.*/
                i++;                  /* Add 1 t0 keep count which index we are in. */
            }
            Node<T> next = curr.getNext();  /* next is set to the curr.Next() */
            curr.setNext(new Node<T>(data));/* It will then set a new node into that setNext */
            curr.getNext().setNext(next);   /* And now the getNext has a setNext to the new next node inserted. */
        }
    }
    
    
    
    
    
     /**
     * Remove duplicates in a sorted list.
     */
    public void removeDuplicates() {
        int count = countNodes();
        
        if (count == 0 || count == 1) { /* If there is only 2 elements. */
            return;
        } else {
            Node<T> curr = head;
            do {
                if (curr.getNext().getData().compareTo(curr.getData()) == 0) {
                    // Skip over the duplicate node. It will be garbage collected
                    // by Java.
                    curr.setNext(curr.getNext().getNext());
                } else {
                    curr = curr.getNext();
                }
            } while (curr.getNext() != null);
        }
    }
    
    
    
    /**
     * Reverse all the nodes in the linked list so that the last node
     * becomes the first node.
     */
    public void reverseList() {
        if(head == null || head.getNext() == null) {
            return;
        }
        Node<T> prev = null;
        Node<T> curr = head;
        while (curr != null) {
            Node<T> next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        head = prev;
    }
   
    
    
    
    
    
    
    
    
    
    
    

    /**
     * Insert the data into the correct position in a sorted list. Assume
     * that the list is sorted in ascending order.
     */
    public void insertSorted(T data) {
        if (countNodes() == 0 || head.getData().compareTo(data) > 0) {
            Node<T> next = head;
            head = new Node<T>(data);
            head.setNext(next);
        }
        else {
            Node<T> curr = head;
            while (curr.getNext() != null && curr.getNext().getData().compareTo(data) < 0) {
                curr = curr.getNext();
            }
            Node<T> next = curr.getNext();
            curr.setNext(new Node<T>(data));
            curr.getNext().setNext(next);
        }
    }

    
    /**
     * Append the nodes of the other list to the end of the current list.
     */
    public void appendList(LinkedList<T> ll) {
        if (ll.head == null) {
            return;
        } else {
            Node<T> curr = ll.head;
            while (curr != null) {
                addNode((T) curr.getData());
                curr = curr.getNext();
            }
        }
    }

    /**
     * Split a linked list into 2 equal parts. If there are an odd number of
     * elements, the extra element should be in the first list.
     */
    public List<Node<T>> frontBackSplit() {
        Node<T> front = null;
        Node<T> back = null;
        // A 0 element list means both the front list and back
        // list will both be null.
        if (head == null) {
            front = null;
            back = null;
        } else if (head.getNext() == null) {
            // For a one element list, include the first element in the
            // front list.
            front = head;
            back = null;
        } else {
            // Move one pointer twice as fast as another.
            Node<T> slow = head;
            Node<T> fast = head;

            while (fast != null) {
                fast = fast.getNext();
                if (fast == null) {
                    break;
                }
                fast = fast.getNext();
                if (fast != null) {
                    slow = slow.getNext();
                }
            }
            front = head;
            back = slow.getNext();
            slow.setNext(null);
        }
        List<Node<T>> list = new ArrayList<>();
        list.add(front);
        list.add(back);
        return list;
    }

    /**
     * Move the head element or the first element from this list to
     * the destination linked list as the destination's new head node.
     */
    public void changeHead(LinkedList<T> destinationList) {
        T currHead = popElement();
        if (destinationList.head == null) {
            // If this is the first element in the destination list , simply
            // add it to the list.
            destinationList.addNode(currHead);
        } else {
            Node<T> next = destinationList.head;
            destinationList.head = new Node<T>(currHead);
            destinationList.head.setNext(next);
        }
    }

    /**
     * Create a new sorted list which is the merged from two original sorted lists.
     * Assume the lists are sorted in ascending order.
     */
    public LinkedList<T> sortedMergeList(LinkedList otherList) {
        if (otherList == null) {
            return this;
        } else if (head == null) {
            return otherList;
        } else {
            Node<T> curr1 = otherList.head;
            Node<T> curr2 = head;
            LinkedList<T> sortedList = new LinkedList<T>();

            while (curr1 != null || curr2 != null) {
                if (curr2 == null ||
                        (curr1 != null && curr1.getData().compareTo(curr2.getData()) < 0)) {
                  sortedList.addNode(curr1.getData());
                  curr1 = curr1.getNext();
                }
                else {
                  sortedList.addNode(curr2.getData());
                  curr2 = curr2.getNext();
                }
            }
            return  sortedList;
        }
    }

    
}
