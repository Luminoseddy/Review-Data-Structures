import java.util.*;
/* Time Complexity: O(N) */
/* <> helps compiler in verifying type safety. "type of" */

public class FindMatchingParenthesis
{
    /* A Map is an object that maps keys to values. A map cannot contain duplicate keys: Each key can map to at most one value. */
    /* Holds the matching parenthesis, and we map the closing brackets with the corresponding open brackets. */
    private static final Map<Character, Character> matchingParenthesisMap = new HashMap<>();
    
    /* A Set is a Collection that cannot contain duplicate elements. */
    /* A set of opening braces we consider valid. */
    private static final Set<Character> openingParenthesisSet = new HashSet<>();

    /* This is a static block. All possible braces to look for and then match it with.  */
    /* Not possible to initialize the hashmap on top this form, hence we create the static block to help. */
    static{
      matchingParenthesisMap.put( ')', '(' );
      matchingParenthesisMap.put( ']', '[' );
      matchingParenthesisMap.put( '}', '{' );
      openingParenthesisSet.addAll(matchingParenthesisMap.values());
    }
   
public static boolean hasMatchingParenthesis(String input){
    try{
        /* When encountering an opening brace, place it in parenthesisStack. */
        Stack<Character> parenthesisStack = new Stack<>(); 

        /* Iterate through the given input. */
        for (int i = 0; i < input.length(); i++){
            char ch = input.charAt(i); /* Let ch be each character from input string. */

            System.out.println("Stack: " + parenthesisStack);
            
            System.out.println("Checking: " + ch);
            if(openingParenthesisSet.contains(ch)){  
                System.out.println("Pushed open brace: " + ch);
                parenthesisStack.push(ch); /* If true, Pushes openBraces into the set */
            }    
            /* If a closing bracket, we compare with the key in matchingParentMap. */
            if(matchingParenthesisMap.containsKey(ch)){
                Character lastParenthesis = parenthesisStack.pop();
                /* If its a closing bracket, we pop the top element. */
                if(lastParenthesis != matchingParenthesisMap.get(ch)){
                    System.out.println("Pop lastParenthesis != matchingParenthesisMap: " + ch);
                    return false;
                }
            }
        }
        return parenthesisStack.isEmpty(); /* If returning empty, all brackets matched */
    }catch(Exception soe){   
        System.err.println("Stack Overflow");
    }
    return false;   
}  
         
    public static void main(String args[]) {
      System.out.println(String.format("Has matching parenthesis %s? : %s", "", hasMatchingParenthesis("{{}}")));
    }     
}

