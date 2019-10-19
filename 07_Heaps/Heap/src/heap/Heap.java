package heap;

import java.lang.reflect.Array;

/**
 * COMPLEXITY: highest priority. 
 * 
 *      Insertion : O( Logn )
 *      Access    : O(1)
 *      Remove    : O(Log n) Because we need to re-heapify. 
 * 
 * Heaps allow you access highest priority in constant time. 
 * 
 * This heap BASE class is a abstract class, it provides methods which real implementations of min max heap need to overwrite
 * 
 * This is a Generic class, the heap can hold values of any type.
 * 
 * Type <T> NEeds to extend Comparable, Its how we will check the priority of the elements. 
 * 
 * Because heap is a type of priority queue, we must extend comparable. 
 * 
 */
public abstract class Heap<T extends Comparable> {

    private static int MAX_SIZE = 40;
    private T[] array; /* Holds the elements from the heap. */
    private int count = 0;

    /* Constructor. */
    public Heap(Class<T> clazz) {
        this(clazz, MAX_SIZE);
    }

    public Heap(Class<T> clazz, int size) {
        array = (T[]) Array.newInstance(clazz, size); /* Instantiate a generic array this way in Java. */
    }

    public void printHeapArray() {
        for (int i = 0; i < count; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();

        try {
           getHighestPriority();
        } catch (HeapEmptyException ex) {

        }
    }

    /* BASE CASE: */
    public int getParentIndex(int index) {
        if (index < 0 || index > count) { /* Check if index is out of range. IF so, return -1. */
            return -1;
        }

        return (index - 1) / 2; /* Return the formula for the correct parent index.  */
    }

    /* BASE CASE: */
    public int getLeftChildIndex(int index) {
        int leftChildIndex = 2 * index + 1; /* Calculate to find the left child index.*/
        if (leftChildIndex >= count) {      /* Count is # of elements in the heap. Check if the left child has a present node. */
            return -1;                      /* If no leftChild was found, return -1; */
        }

        return leftChildIndex;
    }

    /* BASE CASE: */
    public int getRightChildIndex(int index) {
        int rightChildIndex = 2 * index + 2; /* Calculate to find the right child index.*/
        if (rightChildIndex >= count) {      /* Count is # of elements in the heap. Check if the right child has a present node. */
            return -1;                       /* If no leftChild was found, return -1; */
        }

        return rightChildIndex;
    }

    public T getHighestPriority() throws HeapEmptyException {
        
        /* Check for the empty heap. */
        if (count == 0) { throw new HeapEmptyException(); }
            
        /* Return the first element in the array. */
        return array[0];
    }

    public void insert(T value) throws HeapFullException {
        
        if (count >= array.length) { throw new HeapFullException(); }
            
        array[count] = value; /* This is where we append the new inserted value. */
        siftUp(count);        /* Calls itself recursively, till the correct position of that element is found. */

        count++;              /* Indicates there's one more element in the heap. */
    }

    
    
    public T removeHighestPriority() throws HeapEmptyException {
        
        T min = getHighestPriority();
        array[0] = array[count - 1];
        count--;
        siftDown(0);

        return min;
    }
    
    /**
     * Heapify operations, they take 1 element from the wrong position in the heap, and move it upwards or downwards 
     * to place it in the right position.
     * 
     * siftDown: Traverses down the heap towards the leaf nodes to find its right position. 
     * siftup:   Traverses upwards to the root to find its right position in the heap. 
     */
   
    protected abstract void siftDown(int index);
    protected abstract void siftUp(int index);

    
    /* HELPER METHOD: */
    protected void swap(int index1, int index2) {
        T tempValue = array[index1];
        array[index1] = array[index2];
        array[index2] = tempValue;
    }

    /* HELPER METHOD: */
    public int getCount() {
        return count;
    }

    /* HELPER METHOD: */
    public boolean isEmpty() {
        return count == 0;
    }

    /* HELPER METHOD: */
    public boolean isFull() {
        return count == array.length;
    }

    /* HELPER METHOD: */
    public T getElementAtIndex(int index) {
        return array[index];
    }

    public static class HeapFullException extends Exception {}
    public static class HeapEmptyException extends Exception {}
}

