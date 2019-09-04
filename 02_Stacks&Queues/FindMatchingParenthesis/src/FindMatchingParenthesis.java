import java.util.*;
/* Time Complexity: O(N) */
/* <> helps compiler in verifying type safety. "type of" */


/* Algorithm.

- Set up 2 variables.
    - 1: HashMap<>()
    - 2: Hashset<>()
- Create a static block for the hashmap. 
- Create a function, return T/F based on the input string. 
- Declare a Stack variable that holds the open braces.
- Create a forLoop that traverses through the input string.
- Check if its an open bracket, if so, push it to the Stack.
- Check if 
  
  - */

public class FindMatchingParenthesis
{
    private static final Map<Character, Character> matchingParenthesisMap = new HashMap<>(); /* HashMap is a dictionary. */
    private static final Set<Character> openingParenthesisSet = new HashSet<>(); /* HashSet class is used to create a collection that uses a hash table for storage. */

    
    /* This is a static block. All possible braces to look for and then match it with.  */
    /* Not possible to initialize the hashmap on top this form, hence we create the static block to help */
    static{
      matchingParenthesisMap.put( ')', '(' );
      matchingParenthesisMap.put( ']', '[' );
      matchingParenthesisMap.put( '}', '{' );
    }
   
    public static boolean hasMatchingParenthesis(String input){
      try{
        Stack<Character> parenthesisStack = new Stack<>(); /* Set up a stack to hold all opening bracket */

        /* Traverse through each character from the input string. */
        for (int i = 0; i < input.length(); i++){
          char ch = input.charAt(i); /* Let ch be each character from input string */
          
          System.out.println("Pushed brace: " + ch);
          
          if(openingParenthesisSet.contains(ch)){ /*pushes openBraces into the set*/
            parenthesisStack.push(ch);
          }       
          if(matchingParenthesisMap.containsKey(ch)){
            Character lastParenthesis = parenthesisStack.pop();
            if(lastParenthesis != matchingParenthesisMap.get(ch)){
              return false;
            }
          }
        }
        return parenthesisStack.isEmpty(); /* If returning empty, all brackets matched*/
      }catch(Exception soe){
        System.err.println("Stack Overflow");
      }
      return false;   
    }  
         
    public static void main(String args[]) 
    {
      System.out.println(String.format("Has matching parenthesis %s? : %s", "{{{ad}}dd](s)", hasMatchingParenthesis("{{{}}]()")));
    }     
}

