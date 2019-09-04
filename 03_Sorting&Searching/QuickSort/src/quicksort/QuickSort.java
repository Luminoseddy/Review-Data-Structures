/**
 * A Divide and Conquer type of algorithm. 
 * We choose a random pivot in the list. 
 */
package quicksort;

public class QuickSort {

    private static int listToSort[] = new int[] {6, 5, 11, 4, 2, 5, 10, 3, 7, 8, 9};

    public static void main(String[] args) {
        print(listToSort);
        quickSort(listToSort, 0, listToSort.length - 1);
        print(listToSort);
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

    /**
     * Processes recursion to sort the sub-Lists. 
     * 
     */
    public static void quickSort(int[] listToSort, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotIndex = partition(listToSort, low, high);
        quickSort(listToSort, low, pivotIndex - 1);
        quickSort(listToSort, pivotIndex + 1, high);
    }

    /**
     * Finds the pivot, and moves elements to before or after the pivot.
     * 
     * Algorithm:
     *      1. Create a function partition that takes in 3 parameters (int[] listToSort, int low, int high)
     *         (Low & High specify indices which determine the portion of the list.)
     *      2. 
     */
    
    public static int partition(int[] listToSort, int low, int high) {
        int pivot = listToSort[low]; /* Choose the pivot to partition the list, low: loswet element in the index of the list. */
        int l = low;
        int h = high;
        while (l < h) {
            /* Moving from either end of the list towards the center we compare the elements to the pivot. */
            /* Continues as long as the indices don't cross at the center.  */
            while (listToSort[l] <= pivot && l < h) { 
                System.out.println("Index: " + l +" w/ val: "+listToSort[l]);
                printSI("Int l_Index: ", l);
                printSI("Int h_Index: ", h);
                printSI("Pivot: ", pivot);
                l++;
            }
            printS("");
            while (listToSort[h] > pivot) {
                System.out.println("listToSort[h] > " + listToSort[h] + " pivot " +pivot);
                h--;
            }
            printS("");
            if (l < h) {
                swap(listToSort, l, h);
            }
            printS("");
        }
        swap(listToSort, low, h);

        // System.out.println("Pivot2: " + pivot);
        print(listToSort);
        return h;
    }
    
    
    public static void printSI (String a, int b){
        System.out.println(a + b);
    }
    public static void printS (String a){
        System.out.println(a);
    }
}

