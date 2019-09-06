/**
 * A Divide and Conquer type of algorithm. 
 * We choose a random pivot in the list. 
 * 
 * Not adaptive, can't break automatically if sorted already without it completing its full cycle. 
 * Not a stable sorting algorithm.
 * 
 * Main Idea:
 *      1. Always pick the first pivot.
 *      2. The key in Quicksort is the partition().
 *      3. Partition: Given an array, and X, pivot of the array, place X in the correct position
 *                    in the sorted array, then place all smaller elements in the left, and 
 *                    greater elements on the right OF THAT PIvot point.
 * 
 * 
 * Time complexity, O(NlogN)
 */
package quicksort;

public class QuickSort {

    private static int listToSort[] = new int[] {6, 5, 11, 4, 2, 5, 10, 3, 7, 8, 9};
    private static int l = listToSort.length;
    
    public static void main(String[] args) {
        
        quickSort(listToSort, 0, l - 1);
        print(listToSort);
    }

    /* Utility type function. */
    public static void print(int[] listToSort) {
        int x = listToSort.length;
        for(int i = 0; i < x; ++i){
            System.out.print(listToSort[i]+ " ");
        }
    }

    /* Processes recursion to sort the sub-Lists. */
    public static void quickSort(int[] listToSort, int low, int high) {
        /* Stop the sorting if the lower index is not lower than the high Index. */
        if (low < high) {
            
            /* Finds the pivot in the array. */
            int pivotIndex = partition(listToSort, low, high);

            /* Recursively, sort all elements before pivot point. */
            quickSort(listToSort, low, pivotIndex - 1);

            /* Recursively, sort all elements after pivot point. */ 
            quickSort(listToSort, pivotIndex + 1, high);
        }   
    }

    /* Finds the pivot, and moves elements to before or after the pivot. */
    public static int partition(int[] listToSort, int low, int high) {
        /* Element/pivot placed on the left position */
        int pivot = listToSort[high]; 
        int i = (low - 1); /* Index of the smaller element. */
        int h = high;
        
        for (int j = low; j < high; j++){
            
            /* If the current element is smaller than the pivot. */
            if(listToSort[j] < pivot){
                i++;
                int temp = listToSort[i];
                listToSort[i] = listToSort[j];
                listToSort[j] = temp;
            }
        }
        
        /* Swaping listToSort[i+1] and pivot. */
        int temp = listToSort[i +1];
        listToSort[i+1] = listToSort[h];
        listToSort[h] = temp;

        return i + 1;
    }
    
//    public static void swap(int[] listToSort, int iIndex, int jIndex) {
//        int temp = listToSort[iIndex];
//        listToSort[iIndex] = listToSort[jIndex];
//        listToSort[jIndex] = temp;
//    }
    
    public static void printSI (String a, int b){
        System.out.println(a + b);
    }
    public static void printS (String a){
        System.out.println(a);
    }
}

