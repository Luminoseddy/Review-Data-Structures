/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primepalindrome;

/**
 *
 * @author edward
 */
public class PrimePalindrome {
 
    static int max = 200000000;
    
    public static void main(String arg[]){
        
        System.out.println(primePalindrome(45887963));
    }
    
    
  public static int primePalindrome(int n) 
  {
            
    for (int i = n; i < max; i++) {
      if (isPalindrome(i) && isPrime(i)) {
        return i;
      }
    }
    return -1;
  }

  public static boolean isPalindrome(int x) {
      
    int revertedNum = 0;
    if (x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }
      
    while (x > revertedNum) {
      revertedNum = revertedNum * 10 + x % 10;
      x = x / 10;
    }
    return x == revertedNum || x == revertedNum / 10;
  }

  public static boolean isPrime(int x) {
      
    int a = (int) Math.sqrt(x);
      
    if (x == 1) {
      return false;
    }
    if (x == 2) {
      return true;
    }
    if (x%2 == 0) {
      return false;
    }
      
    for (int i = 3; i <= a; i+=2) {
      if (x % i == 0)
        return false;
    }
    return true;
  }
    
}
