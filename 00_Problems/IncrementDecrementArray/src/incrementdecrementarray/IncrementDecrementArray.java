/**
 * 
 * Given an array A of n distinct integer elements with the following property:
 * The first k elements (0 < k < n-1) are in strictly increasing sequence followed by strictly decreasing sequence.
 * 
 * Example:
 * A = {1, 3, 4, 5, 7, 14, 11, 7, 2, -4, -8}. It monotonically increases from 1 to 14, then decreases from 14 to -8.
 * 
 * (a) Implement an efficient program in Java that, given an array with the previous property,
 *     determines whether a given integer is in the array.
 * 
 * (b) What is the running time complexity of the program? O(log n)
 * 
 * 
 * Main Idea:
 * 
 * Use a binary search alogorithm to find the index of the max element in A, 
 * then use binary search to search in each piece. 
 * 
 * 
 * Algorithm:
 *      1. We first need to Sort the array in increasing order. 
 *      2. To make it efficient, we make the elements equal to the middle element, of the sorted array.
 *      3. IF there's an even # of elements, we check for the cost of both middle elements, and take the minimum.
 * 
 *      4. IF S[x] < K, incremement the element by K - S[x]
 *      5. IF S[x] > K, decrement the element by S[x] - K. 
 * 
 */
package incrementdecrementarray;

public class IncrementDecrementArray {

    public static void main(String[] args) {
        
        int[] a = new int[] {1, 3, 4, 5, 7, 14, 11, 7, 2, -4, -8}; 
        int n = a.length;
        int k = max(a, 0, n-1); /* (array, low index, max index) */
        int target = -6;
        
        if(binarySearch_1(a, 0, k+1, target) == -1)
        {
            if (binarySearch_2(a, 0, k+1, target) == -1)
                System.out.println("FALSE");
            else
                System.out.println("TRUE");
        }else
            System.out.println("TRUE");
    }
    
    /**
     * Finds the index of the maximum in a bitonic array, RECURSIVELY
     * 
     * Cycle 1: mid: 5, low: 0, high: 10
     *          IF (a[mid] < a[mid +1])    ==> if (15 > 11) == return max(a, 0, 5); 
     * 
     * Cycle 2: mid: 2, low: 0, high: 5
     *          IF (a[mid] < a[mid +1])    ==> if (4 < 5) == return max(a, 3, 5);         
     *         
     * Cycle 3: mid: 4 , low: 3 , high: 5 
     *          IF (a[mid] < a[mid +1])    ==> if (7 < 14) == return max(a, 5, 5);         
     */
    public static int max(int[] a, int low, int high){
       
        int mid = low + (high - low) / 2;/* Lands us in the middle index of the sorted array */  
        
        System.out.println("mid: "+mid+" low: "+low+" high: "+high);
        
        if(high == low)                 /* Return highIndex if highestIndex == lowest Index */
            return high;     
        
        if(a[mid] < a[mid +1])          /* IF currentIndexVal in list is lessThan than nextIndexVal. */
            return max(a, mid+1, high); /* Recursively return (arrayList, the nextIndex value as the new low, the nextIndex value as the new high) */
              
        if(a[mid] > a[mid + 1])         /* IF currentIndexVal in list is GreaterThan than nextIndexVal. */
            return max(a, low, mid);    /* Recursively, return (arrayList, new low index, the new mid index as the highest index) */  
        
        else 
            return mid;        
    }
    
    /**
     * Binary Search for the increasing sequence.
     * 
     * Cycle 1: first: 0, size: k+1 = 5+1, target: -6
     *          else -> middle = first + size/2    ==>    0 + 6/2     ==>   3 
     *              IF  (target < a[middle])       ==>    (-6 < 5)    ==>   return binarySearch_1(a, 0, 3, -6); 
     *                  
     * Cycle 2: first: 0, size: 3, target: -6
     *          else -> middle = first + size/2    ==>    0 + 3/2     ==>   1
     *              IF (target < a[middle])        ==>    (-6 < 3)    ==>   return binarySearch_1(a, 0, 1, -6);
     *                
     * Cycle 3: first: 0, size: 1, target: -6 
     *          else -> middle = first + size/2    ==>    0 + 1/2     ==>   0
     *              IF (size <= 0)                 ==>    return -1;
     * 
     */
    public static int binarySearch_1 (int[] a, int first, int size, int target){

        int middle;
        
        if(size<= 0)                    
            return -1;
        
        else{
            middle = first + size/2;  
            
            System.out.println("middle: "+middle+" first: "+first+" size: "+size+" target: "+target);
            
            if (target == a[middle])    /* IF the target we're looking for = the array of that index value, return middle. */
                return middle;
            
            else if(target < a[middle]) /* IF the target we're looking for < the array of that index value, return a recursive call. */
                return binarySearch_1(a, first, size/2, target);
            
            else
                return binarySearch_1(a, middle+1, (size-1)/2, target); /* */       
        }                      
    }
    
     /**
     * Binary Search for the decreasing sequence.
     * 
     * Cycle 1: first: 0, size: k+1 = 5+1, target: -6
     *          else ->
     *              middle = 0 + 6/2 ==>  3
     *              else ->      
     *                  return binarySearch_2(a, 3+1, (6-1)/2, -6); 
     * 
     * Cycle 2: first: 4, size: 2, target: -6
     *          else ->
     *              middle = 4 + 2/2 ==>  5
     *              else ->              
     *                  return binarySearch_2(a, 5+1, (2-1)/2, -6);  
     * 
     * Cycle 3: first: 6, size: 0, target: -6
     *          RETURN -1.
     * 
     */
    public static int binarySearch_2 (int[] a, int first, int size, int target){
        
        int middle;
        
        if(size <= 0)
            return -1;
        
        else{
            middle = first + size/2;
            
            System.out.println("middle: "+middle+" first: "+first+" size: "+size+" target: "+target);
            
            if (target == a[middle])
                return middle;
            
            else if(target > a[middle])
                return binarySearch_2(a, first, size/2, target);
            
            else
                return binarySearch_2(a, middle+1, (size-1)/2, target);        
        }                      
    } 
}
