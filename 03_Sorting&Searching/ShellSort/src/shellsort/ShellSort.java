package shellsort;

/**
 * 
 * Complexity: Between O(N^2) and O(N).
 *             Different values of increments produce different complexities. 
 * 
 *             O(N^3/2): Increments of ((2^k)-1) for k = 1, 2, 3... 
 * 
 * Shell sorts uses insertion, the entire list is divided and those subs-lists are sorted.
 * The exact complexity of shell sort is hard because it depends on the increment values chosen.
 * Is not clear what the best increment value is. 
 * 
 * Complexity of shell sort is better than insertion sort as the final iteration with increment = 1
 *    has to work with a nearly sorted list. 
 *
 * Takes insertion sort algorithm, and improves its performance. 
 * 
 * Takes the entire list, and divides it, and the sub list is what is sorted.
 * 
 * 
 * Algorithm: 
 *      - Create helper methods: swap(int[]sortList, int i, int j) {}
 *      - Create function: InsertionSort. 
 * 
 * 
 * 
 * 
 * 
 * 
 */


public class ShellSort {

    private static int listToSort[] = new int[]{3, 5, 6, 8, 10, 1, 2, 4, 7, 9};

    public static void main(String[] args) {
        printS("Shellsort: Given list.");
        print(listToSort);
        printS("\n");
        shellSort(listToSort);
        
    }

    /* Helper method. */
    public static void printS(String x) {System.out.print(x);}
    
    
    
    
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

    public static void insertionSort(int[] listToSort, int startIndex, int increment) { /* Takes in start index&increment value. */
        System.out.println("StartIndex: " + startIndex + " IncrementVal: " + increment);
        for (int i = startIndex; i < listToSort.length; i = i + increment) {            /* All iterations in the list are based on the increment. */
            
            for (int j = Math.min(i + increment, listToSort.length - 1); j - increment >= 0; j = j - increment){ /* If increment =1, we process a regular insertion sort. */
                
                System.out.print("print j: " + j + "\n");
                
                if (listToSort[j] < listToSort[j - increment]) {                        /* Adjacent elements seperated by an increment are comapred. */
                    swap(listToSort, j, j - increment);
                } else {
                    break;
                }
                print(listToSort);
            }
        }
    }

    public static void shellSort(int[] listToSort) {
        int increment = listToSort.length / 2;
        
        while (increment >= 1) {
            for (int startIndex = 0; startIndex < increment; startIndex++) {
                insertionSort(listToSort, startIndex, increment); /* Calls insertion sort on all the sub lists created by elements "increment" apart.*/
            }
            increment = increment / 2; /* Slowly reduces the icnrement value. */
        }
    }
}
