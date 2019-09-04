package insertionsort;
/**
 * Complexity: insertion sort: O(N^2),
 *             Compare: O(N^2)
 *             Swaps:   O(N^2)
 * 
 * 
 * The sort first assumes a sorted Sublist of size 1.
 * Stable sorting systems.
 * Entities bubble to the correct position in the sublist that is sorted.
 * Original order of entities are maintained for equal elements. 
 * 
 * SORT OF CHOICE WHEN USED WITH FASTER ALG. THAT FOLLOW DIVIDE AND CONQUER.
 * 
 * 
 * Worst case, if its descending order and we want to change to ascend order. 
 */

public class InsertionSort {

    private static int listToSort[] = new int[] {3, 5, 6, 8, 10, 1, 2, 4, 7, 9};

    public static void main(String[] args) {
        print(listToSort);
        insertionSort(listToSort);
    }

    public static void print(int[] listToSort) {
        for (int el : listToSort) {
            System.out.print(el + ",");
        }
        System.out.println();
    }

    public static void swap(int[] listToSort, int iIndex, int jIndex) {
        int temp = listToSort[iIndex];
        listToSort[iIndex] = listToSort[jIndex]; 
        listToSort[jIndex] = temp;
    }

    public static void insertionSort(int[] listToSort) {
        for (int i = 0; i < listToSort.length - 1; i++) { /* Goes to 2nd element. */
            for (int j = i + 1; j > 0; j--) {             /* Bubble the element sorted sublist to the right position */
                if (listToSort[j] < listToSort[j - 1]) {
                    swap(listToSort, j, j - 1);
                } else {
                    break; /* If no swap performed, the element has been moved to the right position, and we break.  */
                }
                print(listToSort);
            }
        }
    }
}

