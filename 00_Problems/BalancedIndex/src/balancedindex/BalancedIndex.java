/**
 * The balance index of an array of integers is an index such that the sum of elements at 
 * lower indexes is equal to the sum of elements at higher indexes. The formal definition is:
 * 
 * The integer k is an balance index of a sequence of integers 
 * S[0]; S[1];...; S[n-1] if and only if 0 ≤ k and ∑ i=0,k-1: S[i] and ∑i=k+1, n-1S[i]. 
 * Assume the sum of zero elements is equal to zero.
 * 
 * For example, in a sequence S:
 * [0] = -5; S[1] = 3; S[2] = 7; S[3] = -8; S[4] = -2; S[5] = 5; S[6] = 2
 * 
 * 3 is a balance index, because: S[0]+S[1]+S[2] = S[4]+S[5]+S[6]
 * 6 is also a balance index, because: S[0]+S[1]+S[2]+S[3]+S[4]+S[5]=0
 * 
 * And the sum of zero elements is zero. Note that the index 7 is not a balance index - because it is not a valid index of sequence S.
 * 
 * (a) Implement an efficient function in Java: int balIndex(int S[], int n)
 *     that, given an array S, returns its balance index (any) or -1 if no balance index exists.
 * 
 * (b) What is the running time complexity of your function? 
 * 
 * Algorithm:
 *      1) Initialize leftsum as 0        
 *      2) Get the total sum of the array/sequence as sum
 *      3) Iterate through the array and for each index i, do following.
 *          a) Update sum to get the right sum. 
 *             sum = sum - arr[i]         // sum is now right sum
 *          b) If leftsum is equal to sum, then return current index.
 *          c) leftsum = leftsum + arr[i] // update leftsum for next iteration.
 *      4) return -1                      // If we come out of loop without returning then there is no equilibrium index
 *              
 */
package balancedindex;

public class BalancedIndex {

   // Driver code 
    public static void main(String[] args) 
    { 
        BalancedIndex equi = new BalancedIndex(); 
        int arr[] = { -7, 1, 5, 2, -4, 3, 0 }; 
        int arr_size = arr.length; 
        System.out.println("First equilibrium index is " +  equi.equilibrium(arr, arr_size)); 
                          
    } 
    
    /**
     * Strategy: 
     *      Consider the input array two separate sub-arrays, one to the
     *      left of the element being considered, the other to the right. We step
     *      through the array sequentially until the sums of the sub-arrays are equal.
     */ 
    
    int equilibrium(int arr[], int n) 
    { 
        int sum = 0;      /* initialize sum of whole array */
        int leftsum = 0;  /* initialize leftsum */
  
        /* Find sum of the whole array */
        for (int i = 0; i < n; ++i) {
            sum += arr[i]; 
        }
//        System.out.println("total Sum of the array: "+sum);
            
  
        for (int i = 0; i < n; ++i) { 
            sum -= arr[i];                  /* sum is now right sum for index i */
            System.out.println("Sum: "+sum);
            
            if (leftsum == sum) 
                return i; 
  
            leftsum += arr[i]; 
            
            System.out.println("total leftSum: "+leftsum);
        } 
        System.out.println("total rightSum: "+sum);
        /* If no equilibrium index found, then return 0 */
        return -1; 
    } 
}
