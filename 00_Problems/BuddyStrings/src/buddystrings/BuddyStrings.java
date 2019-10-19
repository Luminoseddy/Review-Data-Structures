/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buddystrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author edward
 */
public class BuddyStrings {
    
    public static void main(String[] arg){
        System.out.println(buddyStrings("aab", "aba"));
    }

     public static boolean buddyStrings(String A, String B) {
        
        /* Base case. */
        if( A.length() != B.length()) return false;
        
        /* Data Structures. */
        boolean a_Repeats = false, b_Repeats = false;   // Keep track if the char's repeat. 
        Set<Character> set_A = new HashSet<>();         // Store the set of characters from A.
        Set<Character> set_B = new HashSet<>();         // Store the set of characters from B.
        List<Integer> indexPosition = new ArrayList<>();// Keep track of the position of those chars to see if those char match.
        
        /* Keep track of the mismatch. */
        for(int i = 0; i < A.length(); i++){
           
            System.out.println("cycle." +(i+1));
            
            
            char a = A.charAt(i); /* The current character in the index of set A. */
            char b = B.charAt(i); /* The current character in the index of set B. */
            
            System.out.println("Set a: " + a);
            System.out.println("Set b: " + b);
            
            /* If it contains a character, return true. */
            if(set_A.contains(a)){ 
                System.out.println("Set a contains a char: " + set_A.contains(a) + "");
                a_Repeats= true;
            } 
                
            /* If it contains a character, return true. */
            if(set_B.contains(b)) {
                System.out.println("Set b contains a char: " + set_B.contains(b) + "");
                b_Repeats= true;
            }
                
            /* IF characters from each set, in index i do not match, return the index. */
            if(a!=b) {
                System.out.println("MisMAtch at index: " + i + "");
                indexPosition.add(i);
            }
            
            /* Adds the character into the set. */
            System.out.println("set_A.add(a): "+set_A.add(a));
            System.out.println("set_B.add(b): "+set_B.add(b));
            
            System.out.print("\n");
            
        }
        
        /* If there are 2 mismatches. */
        if(indexPosition.size() == 2){
            if(A.charAt(indexPosition.get(0)) == B.charAt(indexPosition.get(1)) &&
              A.charAt(indexPosition.get(1)) == B.charAt(indexPosition.get(0))){
                
                System.out.println(A.charAt(indexPosition.get(0)));
                System.out.println(A.charAt(indexPosition.get(1)));
              
                return true;
            }
        }
        
        /* */
        if(A.length() == B.length() && a_Repeats && b_Repeats){
            return true;
        }
        return false;
    }
}
