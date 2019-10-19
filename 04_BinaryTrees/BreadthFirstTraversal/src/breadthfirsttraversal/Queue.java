package breadthfirsttraversal;
import java.lang.reflect.Array;

/**
 * Time Complexity: 
 *      Enqueue/Dequeue : O(N)
 *      isEmpty/isFull  : O(N)
 * 
 * 
 * RECALL: Queue - FIFO or LILO
 * First one added to the queue is the first one out from the queue. 
 * Queue:   adds to the end of the list, removes from the beginning of the list. 
 * 
 * Enqueue: ADDs element to end of the queue.
 * Dequeue: REMOVES the first element from the Queue.
 * Peek:    Looking at the element that we want to dequeue. 
 * isEmpty: Check if the queue has any elements. 
 * isFull:  Check to confirm we can add elements. 
 * Offer:   Adds element to queue if there's space available. 
 * 
 * More Notes:
 * When head and tail are both index 0, there exist only 1 element. 
 * When Head and tail are 1 index from each other, queue is full. 
 */
public class Queue<T> {

    /**
     * Denotes an empty list., This means the size of the queue is 0.
     * The tail can start in -1 spec value or 0. doesn't really matter. 
     * As you enqueue elements, tail increments++.
     * 
     */
    private static final int SPECIAL_EMPTY_VALUE = -1; /* Spec value that flags when there are no elements in the queue */ 
    private static int MAX_SIZE = 40;
    private T[] elements; /* Array list of any data types. */

    /* The head index is initialized to a special value which indicate that the queue is empty. */
    /* The tail is also initialized to the special value to notify there's an empty queue. */
    private int headIndex = SPECIAL_EMPTY_VALUE; 
    private int tailIndex = SPECIAL_EMPTY_VALUE;
    
    int i =0;
    
    
    
    
    /* Constructor: Takes in the Class of the generic type. */
    public Queue( Class<T> clazz) {
        this(clazz, MAX_SIZE);
    }

    public Queue(Class<T> clazz, int size) {
        /* How generic arrays are init. in java. */
        elements = (T[]) Array.newInstance(clazz, MAX_SIZE);
    }
    
    
    public static void main(String[] args) throws QueueOverflowException, QueueUnderflowException{
        
        MAX_SIZE = 4;
        
        Queue<Integer> queue = new Queue<>(Integer.class); // OOP: Creating a new Queue object

//        System.out.println("Queue full?: " + queue.isFull());
//        System.out.println("Queue empty?: " + queue.isEmpty());

        System.out.println("Added 1 to the queue");
        queue.enqueue(1);
        
        System.out.println("Added 2 to the queue");
        queue.enqueue(2);
        
        System.out.println("Added 3 to the queue");
        queue.enqueue(3);
        
        System.out.println("dequeue-ing");
        queue.dequeue();

//        System.out.println("Queue full?: " + queue.isFull());
//        System.out.println("Queue empty?: " + queue.isEmpty());

//        queue.enqueue(4);
//        System.out.println("Queue full?: " + queue.isFull());
//        System.out.println("Queue empty?: " + queue.isEmpty());
//
//        System.out.println("Queue peek: " + queue.peek());
//
//        int data = queue.dequeue();
//        System.out.println("Dequeued element: " + data);
//
//        System.out.println("Peek : " + queue.peek());
//
//        data = queue.dequeue();
//        System.out.println("Dequeued element: " + data);
//        System.out.println("Peek : " + queue.peek());

//        try {
//            queue.enqueue(4);
//            queue.enqueue(5);
//            queue.enqueue(6);
//        } catch (QueueOverflowException soe) {
//            System.out.println("Queue is full! No room available.");
//        }
//
//        try {
//            queue.dequeue();
//            queue.dequeue();
//            queue.dequeue();
//            queue.dequeue();
//            queue.dequeue();
//            queue.dequeue();
//        } catch (QueueUnderflowException sue) {
//            System.out.println("Queue is empty! No elements available.");
//        }
        
    }
    
    

    
    /**
     * Recall: Only tail moves when enqueue
     */
    public void enqueue(T data) throws QueueOverflowException {
              
        /* Base case: Check if its full. If so, throw new qoe. */
        if (isFull()) { throw new QueueOverflowException(); }
            
        System.out.println("Cycle: " + (i+1));
        
        /* Gets */
        tailIndex = (tailIndex + 1) % elements.length;
        System.out.println("Testing tailIndex: "+tailIndex);
            
        elements[tailIndex] = data;     
        System.out.println("head index:  "+ headIndex);
        
        /* This is the first element enqueued, set the head index to the tail index. */
         
        if (headIndex == SPECIAL_EMPTY_VALUE) {
            System.out.println("inside the if");
            headIndex = tailIndex;
        }
        
        System.out.print("\n");
        i++;      
    }

    public boolean offer(T data) {
        if (isFull()) {
            return false;
        }
        try {
            enqueue(data);
        } catch (QueueOverflowException qoe) {
            // Ignore, this should never happen, we've checked for a full queue already.
        }
        return true;
    }


    public T dequeue() throws QueueUnderflowException {
        
        /* Base case. */
        if (isEmpty()) { throw new QueueUnderflowException(); }
            
        /* Access the data present at the head index of the queue. 
         * Save and return the value at the end of this function. */
        T data = elements[headIndex];

        /* We have dequeued the last element in the list. 
           And its possible that it ws the last queue in th list. 
           If so, set the headIndex to its special value to mark it as empty. */
        if (headIndex == tailIndex) {
            headIndex = SPECIAL_EMPTY_VALUE;
        } else {
            /* Incremement the head index by 1. */
            headIndex = (headIndex + 1) % elements.length;
        }
        return data;
    }

    public T peek() throws QueueUnderflowException {
        
        if (isEmpty()) { throw new QueueUnderflowException(); }
            
        return elements[headIndex];        
    }

    /* If it's empty, we return the special value, -1, which flags the list being empty. */
    public boolean isEmpty()  { return headIndex == SPECIAL_EMPTY_VALUE; }
        
       
    /** 
     * This means the head&tail index are next to each other. 
     * Or also, only 2 elements are contained in the queue. (Not full)
     */
    public boolean isFull()  {
        
        /* Calculates to see if the list is full.  */
        int nextIndex = (tailIndex + 1) % elements.length;
   
        /**/
        return nextIndex == headIndex;
    }

    
    public static class QueueOverflowException extends Exception {}
    public static class QueueUnderflowException extends Exception {}
}
