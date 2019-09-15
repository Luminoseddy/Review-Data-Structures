/**
 *  A Heap is a special Tree-based data structure in which the tree is a complete binary tree
 *  There is min-heap and max-heap ..
 * 
 * COMPLEXITY:
 * 
 *      INSERTION: O(log n) average: O( NlogN)
 *      REMOVAL  : O(log n) average: O( NlogN)
 * 
 * SPACE COMPLEXITY: 
 * 
 *          O(1): No additional spaces needed. 
 * 
 */
package heap;

public class HeapSort {

    private static int[] array = {4, 6, 9, 2, 10, 56, 12, 5, 1, 17, 14};

    public static void main(String[] args) {
        printArray();
        heapsort();
        printArray();
    }
    
    private static int getParentIndex(int index, int endIndex) {
        
        if (index < 0 || index > endIndex) { return -1; } /* Check if the index is not out of range. If yes, return -1*/
            
        return (index - 1) / 2; /* If not out of range, return parent index */
    }

    private static int getLeftChildIndex(int index, int endIndex) { 
        
        int leftChildIndex = 2 * index + 1;           /* Formula to find leftChildIndex from the parent index. */
        
        if (leftChildIndex > endIndex) { return -1; } /* Checks if the leftchild Node is present. */
           
        return leftChildIndex;                        /* Return the present left child.*/
    }
    

    
    private static int getRightChildIndex(int index, int endIndex) {
        
        int rightChildIndex = 2 * index + 2;
        
        if (rightChildIndex > endIndex) { return -1; }
            
        return rightChildIndex;
    }

    private static void swap(int index1, int index2) {
        
        int tempValue = array[index1]; /* Hold index1 in a temp variable. */
        array[index1] = array[index2]; /* swap the 2 values in the indeces, letting index1 be index2 */
        array[index2] = tempValue;     /* Then let index 2 be the new temp value. c*/
    }

    
    
    private static void percolateDown(int index, int endIndex) {
        
        int leftChildIndex = getLeftChildIndex(index, endIndex);    /* Get the leftChild Index */
        int rightChildIndex = getRightChildIndex(index, endIndex);  /* Get the rightChild Index. */

        if (leftChildIndex != -1 && array[leftChildIndex] > array[index]) {/* Check if the max heap property is satisfied.  */
            swap(leftChildIndex, index); /* Swap if the heap property is not satisfied. */
            percolateDown(leftChildIndex, endIndex);
        }
        if (rightChildIndex != -1 && array[rightChildIndex] > array[index]) {
            swap(rightChildIndex, index);
            percolateDown(rightChildIndex, endIndex);
        }
    }

    /* Gets the parents of the very last index in the heap. 
     * Then percolates down the elements. */
    public static void heapify(int endIndex) {
         
        int index = getParentIndex(endIndex, endIndex); /* Starts from the parent index of the last element in the array. */
        
        while (index >= 0) {
            percolateDown(index, endIndex); /* Percolate the elements down the heap to the right locations. */
            index--;
        }
    }

    public static void heapsort() {
        
        heapify(array.length - 1); /* Heapify the entire unsorted array so its now a heap. */
        int endIndex = array.length - 1; /* Get the last idex of the heap. */
        
        while (endIndex > 0) {
            swap(0, endIndex); /* Swap the first element with the last element. */
            endIndex--;  /* Decrement the endIndex assuming the last index is in the right position so that we don't come across it again. */
            percolateDown(0, endIndex); /* Recursively return the beginning and last index of the heap. */
        }
    }
    
    public static void printArray() {
        for (int n : array) {
            System.out.print(n + ", ");
        }
        System.out.println();
    }

}

