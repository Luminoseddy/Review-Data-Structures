/**
 * Divides the list into smaller and smaller parts recursively, then focuses and sorting those parts.  
 * MergeSort then sorts the list fully together
 * Divide and conquer uses a recursion, Classic recursion based algorithm.
 */


package mergesort;

public class MergeSort {

    private static int listToSort[] = new int[] {3, 5, 6, 8, 10, 1, 2, 4, 7, 9};

    public static void main(String[] args) {
        print(listToSort);
        mergeSort(listToSort);
    }
    
    
    
    
    
    /* Official MergeSort */
    public static void mergeSort(int[] listToSort) {
        /* Ensures that an odd number of E in a list is sent to the first list. */
        int midIndex = listToSort.length / 2 + listToSort.length % 2; 
        int[] listFirstHalf = new int[midIndex];
        int[] listSecondHalf = new int[listToSort.length - midIndex];
        
        /* Says the list is sorted. */
        if (listToSort.length == 1) { return; }
            
         
        split(listToSort, listFirstHalf, listSecondHalf);
        
        mergeSort(listFirstHalf); /* Recursive calls, merge sort the 2 smaller sub-lists created. */
        mergeSort(listSecondHalf); 
        
        merge(listToSort, listFirstHalf, listSecondHalf); /* Merge the sorted list to get the original list in sorted order. */
        print(listToSort);
    }


    public static void split(int[] listToSort, int[] listFirstHalf, int[] listSecondHalf) {
        int index = 0;
        int secondHalfStartIndex = listFirstHalf.length;
        
        for (int elements : listToSort) 
        {
            /* Holds everything up to the midpoint. */
            if (index < secondHalfStartIndex) {
                listFirstHalf[index] = listToSort[index];
            } else {
                /* 2nd half holds remainder of the elements. */
                listSecondHalf[index - secondHalfStartIndex] = listToSort[index]; 
            }
            index++;
        }
    }

    public static void merge(int[] listToSort, int[] listFirstHalf, int[] listSecondHalf) {
        
        /*  Set up the indices, final merge list, and the other 2 halves that will be merged. */
        int mergeIndex = 0;
        int firstHalfIndex = 0;
        int secondHalfIndex = 0;

        
        while (firstHalfIndex < listFirstHalf.length && secondHalfIndex < listSecondHalf.length){
            
            /* Compare the elements current index of each of the lists and choose smaller one to go into the final list. */
            if (listFirstHalf[firstHalfIndex] < listSecondHalf[secondHalfIndex]) {
                
                System.out.println("ListFirhalfe[i] " +listFirstHalf[firstHalfIndex]);
                System.out.println("ListSechalfe[i] " +listSecondHalf[secondHalfIndex]);
                   
                listToSort[mergeIndex] = listFirstHalf[firstHalfIndex];
       
                firstHalfIndex++;   
            } else if (secondHalfIndex < listSecondHalf.length) {
                listToSort[mergeIndex] = listSecondHalf[secondHalfIndex];
                secondHalfIndex++;
            }
            mergeIndex++;  
        }

        /* Copies over the remaining elements left in either one of the lists. */
        if (firstHalfIndex < listFirstHalf.length) {
            while (mergeIndex < listToSort.length) {
                listToSort[mergeIndex++] = listFirstHalf[firstHalfIndex++];        
            }
        }
        if (secondHalfIndex < listSecondHalf.length) {
            while (mergeIndex < listToSort.length) {
                listToSort[mergeIndex++] = listSecondHalf[secondHalfIndex++];   
            }
        }
    }
    
    public static void print(int[] listToSort) {for (int el : listToSort) { System.out.print(el + ","); } printS("\n");}
    public static void printS(String x) {System.out.print(x+"\n");}   
}


    /** 
    * Algorithm: MergeSort
    *          1. Create a function MergeSort that takes in a list. 
    *          2. Create 3 Variables. int midIndex, int[] listFirstHalf, int[] listSecondHalf
    *          3. Create a check. if the lists length = 1, then the list is "sorted", & return. 
    *          4. Call the split function which takes a list and divide them into 2 sub-list. 
    *          5. Recursively, mergeSort the 2 sub-lists.  
    *          6. Call the merge function which takes to 2 mergedSorted sublists, and mergeSorts them into 1. 
    *          7. Print the sorted list. 
    */


    /**
     * Helper methods: split, merge
     * Algorithm: 
     *      1. Create a split function that takes in 3 list: int[] listToSort, int[] listFirstHalf, int[] listSecondHalf
     *      2. Create a variable for the index of a list.
     *      3. Create another variable for the secondHalfStartIndex. 
     *      4. Create a forLoop that traverses through the list. 
     *      5. Check if the index value is lessThan secondHalfStartingIndex
     *      6.       if so, then the firstHalf of the list at that index is=to the original listToSort at that index
     *      7.       else, then the secondHalf of the list at that [index-secondHalfStartIndex] is equal to listToSort[index]; 
     *      8. Increment to the next index. index++
     */ 

    
    /**
     * Merges the 2 sorted lists, into 1 sorted list. 
     * Algorithm:
     *      1. Create a split function that takes in 3 list: int[] listToSort, int[] listFirstHalf, int[] listSecondHalf
     *      2. Create 3 variables. mergeIndex, firstHalfIndex, secondHalfIndex
     *      3. Create a whileLoop. 
     *            While the (firstHalf of the list of that Index is lessThan listFirstHalf.length) AND 
     *                      (the firstHalf of the list of that Index is lessThan listFirstHalf.length )
     *      4. If the listFirstHalf of that index is lessThan listSecondHalf of that index. 
     *      5.    then the listToSort[mergeIndex] is = to listFirstHalf of that index. 
     *      6.    then increment the firstHalfIndex.
     *      7. Else if (secondHalfIndex is lessThan listSecondHalf.length)
     *      8.      then, the listToSort[mergeSort] is= to the listSecondHalf of the index.
     *      9.      then increment secondHalfIndex
     * 
     *      10. Copy over the remaining elements left in either lists by checking,
     *      11. IF (firstHalfIndex is lessThan listFistHalf.length)
     *      12.     WhileLoop (mergeIndex is lessThan listToSort.length)
     *      13.          The listToSort[mergeIndex++] is= listOfFirstHalf of that index
     *      14. IF (secondHalfIndex is lessThan listsecondHalf.length)
     *      15.     WhileLoop (mergeIndex is lessThan listToSort.length)
     *      16.         The listToSort[mergeIndex++] is= listOfSecondHalf of that index
     * 
     */