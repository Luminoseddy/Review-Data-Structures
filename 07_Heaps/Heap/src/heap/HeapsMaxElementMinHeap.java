/**
 * 
 * Find max value in a min heap.
 * 
 * Algorithm:
 *      1. Scan only through the leaf nodes to find the max integer in the heap.
 *         NOTE: First leaf node comes after the last internal(parent) node. Parent of the last node in the heap. 
 *         
 * 
 * 
 */
package heap;

public class HeapsMaxElementMinHeap {

    public static void main(String[] args) throws MinHeap.HeapEmptyException, MinHeap.HeapFullException{
            
        MinHeap<Integer> minHeap = new MinHeap<>(Integer.class);

        minHeap.insert(9);
        minHeap.insert(4);
        minHeap.printHeapArray();
        minHeap.insert(7);
        minHeap.insert(6);
        minHeap.insert(3);
        System.out.println("Maximum element: " + getMaximum(minHeap));
        minHeap.printHeapArray();
        minHeap.insert(11);
        minHeap.insert(15);
        minHeap.printHeapArray();
        minHeap.insert(5);
        minHeap.insert(9);
        minHeap.insert(2);
        minHeap.printHeapArray();

        System.out.println("Maximum element: " + getMaximum(minHeap));
    }


    public static int getMaximum(MinHeap<Integer> minHeap) {
        
        int lastIndex = minHeap.getCount() - 1; /* Get the last leaf node in the heap. */
        int lastParentIndex = minHeap.getParentIndex(lastIndex); /* Find the parent index of the last node index. */

        int firstChildIndex = lastParentIndex + 1; /* First leaf node, after the last parent element. */

        int maxElement = minHeap.getElementAtIndex(firstChildIndex);
        
        /* Iterate through all the leaf nodes starting at indexes after the index of the last parent node. */
        for (int i = firstChildIndex; i <= lastIndex; i++) {
            if (maxElement < minHeap.getElementAtIndex(i)) {
                maxElement = minHeap.getElementAtIndex(i);
            }
        }

        return maxElement; /* Return max element after traversing all the leaves. */
    }
}

