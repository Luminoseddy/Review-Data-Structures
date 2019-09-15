package heap;

public class HeapsKLargestElements {

    public static int[] randomNumberArray = new int[] {2, 5, 6, 21, 67, 88, 4, 1, 3, 9, 99};

    public static void main(String[] args) throws MinHeap.HeapEmptyException, MinHeap.HeapFullException {
            
        printMaximumKElements(3);
        printMaximumKElements(5);
        printMaximumKElements(6);
    }

    /* K is the argument to the function indicating how many elements we want to store, */
    public static void printMaximumKElements(int k) throws MinHeap.HeapEmptyException, MinHeap.HeapFullException {
            
        MinHeap<Integer> minHeap = new MinHeap<>(Integer.class, k); /* k is the capacity of the heap. */

        for (int number : randomNumberArray) { /* Iterates through the list of numbers in either an array, or user input values. */
            if (minHeap.isEmpty()) {           /* If empty then just throw the first 5 elements into the list.  */
                minHeap.insert(number);
                
              /* IF is not full OR incoming element is greater than K smallest element */
            } else if (!minHeap.isFull() || minHeap.getHighestPriority() < number) { 
                if (minHeap.isFull()) { /* Incase the heap is full. */
                    minHeap.removeHighestPriority(); /* Remove the smallest element from the heap. */
                }
                minHeap.insert(number); /* Insert the new element. */
            }
        }
        minHeap.printHeapArray();
    }
}