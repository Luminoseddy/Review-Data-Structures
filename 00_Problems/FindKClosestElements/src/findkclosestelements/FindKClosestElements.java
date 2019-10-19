
package findkclosestelements;


public class FindKClosestElements {

   
    public static void main(String[] args) {
        FindKClosestElements ob = new FindKClosestElements(); 
        
        int arr[] = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56}; 
                       
        int n = arr.length; // recall: returns regular counting. 1-13 not 0-12
        int x = 35, k = 4; 
        
      
        System.out.println("{12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56}; \n\n");
        
        ob.printKclosest(arr, x, 4, n); 
    }
    
    /** 
     * Function to find the cross over point.
     * The point before which elements are smaller than or equal to x and after which greater than x */

    // 1. (arr, 0, 12, 35)
    // 2. (arr, 0, 5, 35)
    // 3. (arr, 3, 5, 35) 
    int findCrossOver(int arr[], int low, int high, int x) 
    { 
        
      
        /* BASE CASE: x is greater than all. */
        // 1. arr[12] <= 35? -> False
        // 2. arr[5] <= 35? -> False
        // 3. arr[5] <= 35? -> False
        if (arr[high] <= x) return high;  
           
        /* BASE CASE: x is smaller than all. */
        // 1. arr[0] > 35? -> False
        // 2. arr[0] > 35? -> False
        // 3. arr[3] > 35? -> False
        if (arr[low] > x) return low; 
            
        /* Find the middle point :  low + (high - low)/2 */
        // 1. mid = (0+12) / 2 = 6
        // 2. mid = (0+5) /2 = 2
        // 3. mid = (3+5) / 2 = 4
        int mid = (low + high)/2;  
  
        /* If x is same as middle element, then return mid */   
        // 1. arr[6] <= 35 && arr[7] > 35? -> False
        // 2. arr[2] <= 35 && arr[3] > 35? -> False
        // 3. arr[4] <= 35 && arr[5] > 35? -> True, return 4. 
        if (arr[mid] <= x && arr[mid+1] > x) return mid; 
                  
        /* If x is greater than arr[mid], then either arr[mid + 1]is ceiling of x or ceiling lies in arr[mid+1...high] */    
        // 1. arr[6] < 35? -> False.
        // 2. arr[2] < 35? -> True : return (arr, 3, 5, 35)
        if(arr[mid] < x) return findCrossOver(arr, mid+1, high, x); 
            
        // 1. return (arr, 0, 5, 35)  RECURSION
        return findCrossOver(arr, low, mid - 1, x); 
    } 
  
    // This function prints k closest elements to x in arr[]. n is the number of elements in arr[] 
    
    // 1. printKclosest(arr, 35, 4, 13)
    void printKclosest(int arr[], int x, int k, int n) 
    { 
   
        // 1. l = 4. (arr, 0, 12, 35) 
        int l = findCrossOver(arr, 0, n-1, x);  
             
        // 1. r = 5
        int r = l+1;   // Right index to search 
        
        int count = 0; // To keep track of elements already printed 
                       
  
        // If x is present in arr[], then reduce left index. Assumption: all elements in arr[] are distinct (different) 
        // 1. 35 == 35? -> True l = 3
        if (arr[l] == x) l--; 
  
           
        // Compare elements on left and right of crossover, point to find the k closest elements 
        
        // 1. 3 >= 0 && 6 < 13 && 0 < 4 -> True
        // 2. 3 >= 0 && 7 < 13 && 1 < 4 -> True
        // 3. 2 >= 0 && 7 < 13 && 2 < 4 -> True
        // 4. 2 >= 0 && 8 < 13 && 3 < 4 -> True
        while (l >= 0 && r < n && count < k) 
        {    
            // 1. (35-arr[3])<(arr[6]-35): 5<4 -> False r = 7  : print(arr[5]) 39
            // 2. (35-arr[3])<(arr[7]-35): 5<7 -> True l = 2   : print(arr[3]) 30
            // 3. (35-arr[2])<(arr[7]-35): 13<10 -> False r = 8: print(arr[7]) 45
            // 4. (35-arr[2])<(arr[8]-35): 13<13 -> False r = 9: print(arr[8])   
            if (x - arr[l] < arr[r] - x) 
                System.out.print(arr[l--]+" "); 
            else
                System.out.print(arr[r++]+" "); 
            
            // 1. +1
            // 2. +1
            // 3. +1
            // 4. +1 break from loop. count = 4;
            count++; 
        } 
  
        // If there are no more elements on right side, then print left elements 
        // 1. 4 < 4 && 2 >= 0 -> False
        while (count < k && l >= 0) 
        { 
            System.out.print(arr[l--]+" "); 
            count++; 
        } 
  
  
        // If there are no more elements on left side, then print right elements 
        // 4 < 4 && 3 < 13
        while (count < k && r < n) 
        { 
            System.out.print(arr[r++]+" "); 
            count++; 
        } 
    }  
}
