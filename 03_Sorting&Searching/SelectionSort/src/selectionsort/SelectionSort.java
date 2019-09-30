package selectionsort; 
/* Complexity: Sort: O(N^2) ; Swap: O(N) */

/**
 * 
 * Each iteration 1 E is selected and compared with every other E in the list to 
 * find the smallest one. 
 * 
 * Selects one E at a time and compares to all other E in the list. 
 * Correct position is found for that selected E before moving on the next E.
 *
 * Not too stabled, entities that are equal might be re-arranged.
 * 
 * 
 * Algorithm:
 *      1. Helper methods: 
 *          Print(int[] listToSort){}
 *          swap([] listToSort, int iIndex, int jIndex)
 * 
 *      2. selectionSort(int[] listToSort)
 */

public class SelectionSort {

    private static int listToSort[] = new int[] {4, 5, 6, 2, 1, 7, 10, 3, 8, 9};

    public static void main(String[] args) {
        print(listToSort);
        selectionSort(listToSort);
    }

    public static void print(int[] listToSort) {
        for (int el : listToSort) {
            System.out.print(el + ",");
        }
        System.out.println();
    }

    public static void swap(int[] listToSort, int i, int j) {
        
        
        int temp = listToSort[i]; /* Ex. temp [2]: 6. */
        listToSort[i] = listToSort[j]; /* [2]: 6 is now in [3] where 2 was.   */
        listToSort[j] = temp; /* and now index [3] value has swapped into index[2]. */
      
    }

    public static void selectionSort(int[] listToSort) {
        for (int i = 0; i < listToSort.length; i++) {
            for (int j = i + 1; j < listToSort.length; j++) {
                
                if (listToSort[i] > listToSort[j]) { /* If index[i] is greater than the index[j], then swap. */
                    swap(listToSort, i, j);
                }
            }
            print(listToSort);
        }
    }
}
