package queuebuiltwithtwostacks;

import java.util.Stack;

/**
 *  Time Complexity: 
 *      enqueue/dequeue : O(1)
 * 
 * Any one operation, the element can't be pushed / popped more than twice. 
 */


public class QueueBuiltWithTwoStacks<T> {

    /* Data Structure. */
    /* Set up the 2 stacks. Generic class that holds any data type. */
    private Stack<T> forwardStack = new Stack<>(); /* Enqueue happens on the forward stack. */
    private Stack<T> reverseStack = new Stack<>(); /* Dequeue happens on the reverse stack. */

    /* Constructor. */
    public QueueBuiltWithTwoStacks() {

    }

    public static void main(String[] args)
            throws Queue.QueueOverflowException, Queue.QueueUnderflowException {
        
        /* Creates an instance of the class. */
        QueueBuiltWithTwoStacks<Integer> queue = new QueueBuiltWithTwoStacks<Integer>(); 

        System.out.println("Queue full?: " + queue.isFull());
        System.out.println("Queue empty?: " + queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Queue full?: " + queue.isFull());
        System.out.println("Queue empty?: " + queue.isEmpty());

        queue.enqueue(4);
        System.out.println("Queue full?: " + queue.isFull());
        System.out.println("Queue empty?: " + queue.isEmpty());


        int data = queue.dequeue();
        System.out.println("Dequeued element: " + data);


        data = queue.dequeue();
        System.out.println("Dequeued element: " + data);

        try {
            queue.enqueue(4);
            queue.enqueue(5);
            queue.enqueue(6);
        } catch (Queue.QueueOverflowException soe) {
            System.out.println("Queue is full! No room available.");
        }

        try {
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
        } catch (Queue.QueueUnderflowException sue) {
            System.out.println("Queue is empty! No elements available.");
        }

    }

    public void enqueue(T data) throws Queue.QueueOverflowException {
        
        /* Base case:  */
        if (isFull()) { throw new Queue.QueueOverflowException(); }
      
        try {
            if (forwardStack.isEmpty()) { /* Check ifEmpty on forStack. */
                
                /* BUT if revStack is not empty. It means all elements are present in the revStack. Prob last operation was a dequeue.   */
                while (!reverseStack.isEmpty()) { 
                    /* Take all elements from revStack and push it into forwardStack. */
                    forwardStack.push(reverseStack.pop());
                }
             }
            forwardStack.push(data);
        } catch (Stack.StackOverflowException || Stack.StackUnderflowException se) {
            throw new Queue.QueueOverflowException();
        }
    }
        
   
    public T dequeue() throws Queue.QueueUnderflowException {
        
        /* Base case: */
        if (isEmpty()) { throw new Queue.QueueUnderflowException(); }
            
        /* If !empty, check revStack. Recall: All dequeue's happen in revStack. */
        try {
            /* If revStack isEmpty() && forwardStack !isempty() then pop all elements from forwardStack and push it into revStack. */
            if (reverseStack.isEmpty()) {
                while (!forwardStack.isEmpty()) {
                    reverseStack.push(forwardStack.pop());
                }
            }

            return reverseStack.pop();
        } catch (Stack.StackOverflowException | Stack.StackUnderflowException se) {
            throw new Queue.QueueUnderflowException();
        }
    }

    
    /* Base Case: */
    public boolean isFull() {
        return forwardStack.isFull() || reverseStack.isFull();
    }

    /* Base Case: No elements have been added to the queue. */
    public boolean isEmpty() {
        return forwardStack.isEmpty() && reverseStack.isEmpty();
    }

}

