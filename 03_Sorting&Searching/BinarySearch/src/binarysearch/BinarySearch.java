package binarysearch;

/**
 * Binary Search:
 *      - Search the SORTED ARRAY by constantly dividing the search interval by half. 
 *      - Start with interval holding the entire array.
 *      - If the search KEY is less than the element in the middle of the interval, cut down the interval to the lower half.
 *      - Else, narrow it to the upper half. 
 *      - Repeatedly check until the value is found or the interval is empty.
 * 
 * Algorithm:
 *      - Compare the key with the middle element.
 *      - If the key matches the middle element, return the middle element.
 *      - Else, IF the key is greater than the middle element, then the key lies in the right half subarray
 *      - Else, key is on the left subarray.
 *      - Continue this process in a while loop till the entire list has been searched, return the key value if found
 *        else, return -1 if value does not exist. 
 * 
 * Time Complexity: O(logN)
 */

public class BinarySearch {

    public static void main(String[] args) {
        
        int sortedList[] = { 2, 3, 4, 10, 40, 41, 43, 54, 65, 76, 87, 98, 1001, 2111, 3222, 4333}; 
        
        int key = 98;
        
        if (binarySearch(sortedList, key) == -1){
            System.out.println("Error - Value '"+key+"' does not exist.");
        } else{
            System.out.println("Value: '"+key+"' has been spotted in the list!");
        }
    }
    
    public static int binarySearch(int[] sortedList, int key){
        
        int min = 0;                    /* First index in the list. */
        int max = sortedList.length -1; /* Last index in the list. */
        
        while(min <= max){
            
            int mid = min + (max - min) / 2; /* Locate the mid point of the list. */
            
            /* If the key is located right in the middle */
            if (sortedList[mid] == key) { return mid; }   
                
            
            
            if (sortedList[mid] > key){ /* If the key is lessThan the current midPoint of the list */
                max = mid-1;            /* Return a new max, being the the new length of the list. */
            } else {
                System.out.println("mid: "+mid);
                min = mid +1;           /* Else, the value is in the right side of the subarray.  */
            }
        }
 
        return -1; /* If its not in the array return -1 */
    }
}
