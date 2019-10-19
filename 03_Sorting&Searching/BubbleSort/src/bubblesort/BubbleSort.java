package bubblesort; 
/* Complexity: Compare: O(N^2), Swap O(N^2) */


/**
 * For each iteration, every E is compared with its neighbor
 * 
 * Bubble sort can start at the front OR end of the list (this case end of list)
 * 
 * It starts comparing its neighbor values and swapping the E's into 
 * ascending order, from one end to the other end of the list. 
 * 
 * The end of the first iteration, the smallest E is placed in the right position. 
 */

public class BubbleSort {

    private static int listToSort[] = new int[] {3, 5, 6, 8, 10, 1, 2, 4, 7, 9};

    public static void main(String[] args) {
        print(listToSort);
        bubbleSort(listToSort);
    }
   
    public static void print(int[] listToSort) {
        for (int el : listToSort) {
            System.out.print(el + ",");
        }
        System.out.println();
    }
 
    public static void swap(int[] listToSort, int iIndex, int jIndex){
        int temp = listToSort[iIndex];   
        listToSort[iIndex] = listToSort[jIndex];
        listToSort[jIndex] = temp;
    }

   
    public static void bubbleSort(int[] listToSort) {
        
        for (int i = 0; i < listToSort.length; i++) {
            boolean swapped = false;
            
            for (int j = listToSort.length - 1; j > i; j--) {      
                if (listToSort[j] < listToSort[j - 1]) {            
                    System.out.println("j: " + listToSort[j] + ". j-1: " + listToSort[j-1] + " have been swapped.");
                    swap(listToSort, j, j - 1);
                    swapped = true;
                }      
            }
            print(listToSort);
            if (!swapped) {
                break;
            }
        }
    }
}

