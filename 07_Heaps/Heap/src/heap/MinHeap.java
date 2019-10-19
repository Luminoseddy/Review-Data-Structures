package heap;

public class MinHeap<T extends Comparable> extends Heap<T> {

    public static void main(String[] args) throws HeapFullException, HeapEmptyException {
        MinHeap<Integer> minHeap = new MinHeap<>(Integer.class);

        minHeap.insert(9);
        minHeap.insert(4);
        minHeap.insert(17);
        minHeap.printHeapArray();
        minHeap.insert(6);
        minHeap.printHeapArray();

        minHeap.insert(100);
        minHeap.insert(20);
        minHeap.printHeapArray();
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.printHeapArray();

        minHeap.removeHighestPriority();
        minHeap.printHeapArray();
        minHeap.removeHighestPriority();
        minHeap.printHeapArray();
    }

    /* Constructors */
    public MinHeap(Class<T> clazz) {
        super(clazz);
    }
    
    
    /* Constructors */
    public MinHeap(Class<T> clazz, int size) {
        super(clazz, size);
    }

    @Override
    protected void siftDown(int index) {              /* Pass in a specific index that needs to be shifted down.  */
        int leftIndex = getLeftChildIndex(index);     /* Obtain the left child indeces from the node that needs to be shifted down. */
        int rightIndex = getRightChildIndex(index);   /* Obtain the right  child indeces from the node that needs to be shifted down. */    
        int smallerIndex = -1;                        /* Store the minimum one of the left and right child elements. */
        
        /* If both left and right child are present (not -1), then choose smaller index from left / right child.  */
        if (leftIndex != -1 && rightIndex != -1) {
            smallerIndex = getElementAtIndex(leftIndex).compareTo(getElementAtIndex(rightIndex)) < 0
                    ? leftIndex : rightIndex;   
        } 
       
        else if (leftIndex != -1) { smallerIndex = leftIndex; }    /* If theres only a right child, then thats the min value */
          
        else if (rightIndex != -1) { smallerIndex = rightIndex; }  /* If theres only a left child, then thats the min value */
               
        if (smallerIndex == -1) { return; }                        /* If the left and right child do not exist stop sifting down. */
            
        /* Compare the smaller child with the parent index to see if a swap and further sift down is needed. */
        if (getElementAtIndex(smallerIndex).compareTo(getElementAtIndex(index)) < 0) {
            swap(smallerIndex, index);  /* Swap the element smaller child element in that index with the parent value. */
            siftDown(smallerIndex);     /* Recursively called until the element is in its right index. */
        }
    }

    @Override
    protected void siftUp(int index)  {          /* Takes in the element thats in the wrong position, and sifted up. */
        int parentIndex = getParentIndex(index); /* Find the parent element of the current node. */

        if (parentIndex != -1 && getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) < 0) {
                
            swap(parentIndex, index);            /* If the parent is smaller than the current node, swap. */
            siftUp(parentIndex);
            
            System.out.println("swap "+ parentIndex +" index "+index);
            System.out.println("getElementAtIndex(index) "+getElementAtIndex(index)+" (getElementAtIndex(parentIndex) "+getElementAtIndex(parentIndex));
            System.out.println("siftUp(parentIndex) "+ parentIndex);
        }
    }
}

