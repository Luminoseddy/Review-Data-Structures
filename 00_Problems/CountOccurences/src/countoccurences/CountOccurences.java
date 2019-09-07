/**
 * Given a sorted array of integer, A, with possible duplicate elements.
 * 
 * (a) Implement an efficient function in Java to find in A, the numbers of occurrences of the input value k.
 * 
 *     For example, in an array A = {-1, 2, 3, 5, 6, 6, 6, 9, 10} and k = 6, your program should return 3.
 * 
 * (b) What is the running time complexity? --> O(log n).
 * 
 * 
 * 
 * Algorithm: 
 *      - Using a binary search, get index of the first occurrence of key in A[]. 
 *        And let it be i.
 *      - Get index of the last occurrence of key in A[]. 
 *        And let it be j.
 *      - Finally we return(j-i+1) which counts from first to last and gives the total.
 * 
 */
    
package countoccurences;

public class CountOccurences {

    
    public static void main(String args[]) 
    { 
        int A[] = {-1, 2, 3, 5, 6, 6, 6, 9, 10}; 

        /* Element to be counted in A[] */
        int key =  6;  
        int n = A.length; 
        int c = countOccurrences(A, key, n); 

        System.out.println("There are "+c+" clones of the value "+key); 
    } 

    /* if key is present in the array A[] then return the number of occurrences of that key, else return -1. */ 
    public static int countOccurrences(int A[], int key, int n) 
    { 
        int i;  /* index of first occurrence of key */  
        int j;  /* index of last occurrence of key  */

        i = first(A, 0, n-1, key, n); /* get the index of first occurrence of key */

        /* If the key doesn't exist in arr[] then return -1 */
        if (i == -1) 
          return i; 

        /* Else get the index of last occurrence of key. NOTE: We're only looking in the subarray after first occurrence */   
        j = last(A, i, n-1, key, n);      
        
    return j-i+1; 
    } 
       
    /* if key is present in A[] then returns the index of FIRST occurrence of key in arr[0..n-1], otherwise returns -1 */
    public static int first(int A[], int low, int high, int key, int n) 
    {   
        /**
         * Cycle 1: mid= 4, key= 3, a[mid]= 6, a[mid-1]= 5, n= 5
         *              <- Recursively ->
         *              return(A[], 0, mid-1, key, n) ==> return(A[], 0, 3, 3, 9)
         * Repeat.
         */             
        if(high >= low) 
        { 
            int mid = (low + high) / 2; /* Locate to the middle index of the array. */   
            System.out.println(A[mid]);
            if (( mid == 0 || key > A[mid-1]) && A[mid] == key) 
              return mid; 

            /* IF key is greter than mid, then the key is after the mid point. */
            else if(key > A[mid]) 
              return first(A, (mid + 1), high, key, n); 

            /* Else the key value is before the mid point. */
            else
              return first(A, low, (mid -1), key, n); 
        } 
        return -1; 
    } 
       
    /* if x is present in arr[] then returns the index of LAST occurrence of x in arr[0..n-1], otherwise returns -1 */
    public static int last(int arr[], int low, int high, int x, int n) 
    { 
        if(high >= low) 
        { 
            /*low + (high - low)/2;*/      
            int mid = (low + high)/2;  

            /* If the value is at mid, && and the value just after mid is greater than the key */
            if( ( mid == n-1 || x < arr[mid+1]) && arr[mid] == x ) 
              return mid; 
            
            /** If the key is less than the middle value, recursively return.
             *  Then the key can be found before the mid point. */
            else if(x < arr[mid]) 
              return last(arr, low, (mid -1), x, n); 
            
            /* Else, the key can be found after the mid point. */
            else
              return last(arr, (mid + 1), high, x, n);       
        } 
        return -1; 
    }     
}
