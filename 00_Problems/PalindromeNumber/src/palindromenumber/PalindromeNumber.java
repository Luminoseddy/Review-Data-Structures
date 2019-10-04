/**
 * Determine whether an integer is a palindrome. 
 * 
 * Algorithm:
 *      - Set up a variable that holds the reversed value. 
 *      - Create checks:
 *          a. Ensure a negative is not excepted. Can't be a palindrome. (-121 != 121-).
 *          b. Ensure input value is not a perfect mod10 and does not equal 0.
 * 
 *      - Create a whileLoop, that continues cycling for as long as the input value is less than the reversed value. 
 *      - Assuming we're checking for 121.
 *      - Doing (121 mod10) we get the last digit, 1.
 *      - Now to get the 2nd last digit, we need to remove the last digit from 121, simply divide by 10. (121/10) = 12
 *      - Then the last digit can be obtained by (mod10), (122mod10) = 2.     
 */

/**
         * Assume x = 121
         * 
         * Cycle 1: revertedNum = 0 * 10 + 121 % 10 ==> 1  = revertedNum
         *          x = 121/10                      ==> 12 = x
         * 
         * Cycle 2: revertedNum = 1 * 10 + 12 % 10  ==> 12  = revertedNum
         *          x = 12/10                       ==> 1  = x
         *          
         * Cycle 3: revertedNum = 12 * 10 + 1 % 10   ==> 121  = revertedNum
         *          x = 1/10                        ==> 0  = x
         * 
         */

package palindromenumber;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) 
    {
        int numberReversed = 0; /* starting value of the number trying to be reverted. */
        int remainder = 0;
        
        /* Base case */ 
        if( x < 0 || (x % 10 == 0 && x != 0)){ return false; }
              
        while(x > numberReversed){
            
            remainder = x % 10; // get remainder of x. 
            numberReversed = numberReversed * 10 + remainder; // mult. rev# by 10, then add remainder. 
            x = x/10; // to remove last int
                  
        }
        
        // return x == numberReversed/10 for odd length numbers. 
        
        return x == numberReversed || x == numberReversed/10;
    }
    
    public static boolean isPalindrome(String s) {
        // Pointers pointing to the beginning and the end of the string 
        int i = 0;
        int j = s.length() - 1; 
        
        char frontIndex;
        char endIndex;
  
        // While there are characters toc compare 
        while (i <= j) {     
            frontIndex = s.charAt(i);
            endIndex = s.charAt(j);
  
            if (s.isEmpty()) {
        	    return true;
            }
            
            if (frontIndex != endIndex)
            {
                if(frontIndex != Character.toUpperCase(endIndex) || Character.toUpperCase(frontIndex) != endIndex)
                    return false;
            }
            // Increment first pointer and 
            // decrement the other 
            i++; 
            j--;            
        } 
        // Given string is a palindrome 
        return true; 
    }
    
    public static void main(String arg []){
      
        System.out.println("\nare the numbers palindrome?: "+isPalindrome(1221));
        System.out.println("are the strings palindrome?: "+isPalindrome("anA")); 
    }
}
