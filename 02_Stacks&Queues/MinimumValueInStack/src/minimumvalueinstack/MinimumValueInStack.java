package minimumvalueinstack;
import java.util.Stack;

/**
 * Algorithm:
 * 
 * Recall: Push -> inserts to end of list.
 *         Pop  -> removes the last E in the list.
 * 
 * 
 * Create 2 stacks: 1 for all values, other for min value.
 * 
 * Create a push function that takes an integer.
 *      Declare the passed dataInt to be the minData at start.
 * 
 *      if the minStack is not empty 
 *          -> if the the passed dataInt is greater than the top value of the minStack 
 *              then, minDataInt = minStack.
 *      
 *      If none of those conditions meet, push dataInt into the stack, 
 *      and push minDataInt into minStack.
 * 
 * 
 * 
 */



public class MinimumValueInStack {

    public static void main(String[] args) throws Exception{  
        MinimumStack minimumStack = new MinimumStack();
        
        minimumStack.push(2);
        minimumStack.push(4);
        minimumStack.push(10);
        
        System.out.println("Regular stack: " + MinimumStack.stack);
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());
        
        minimumStack.push(1);
        System.out.println("Regular stack: " + MinimumStack.stack);
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());
        
        minimumStack.push(0);
        System.out.println("Regular stack: " + MinimumStack.stack);
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());
        

        minimumStack.pop();
        System.out.println("Regular stack: " + MinimumStack.stack);
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());
        
        minimumStack.pop();
        System.out.println("Regular stack: " + MinimumStack.stack);
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());
        
        minimumStack.pop();
        System.out.println("Regular stack: " + MinimumStack.stack);
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());
    }

    public static class MinimumStack {
        
        private static Stack<Integer> stack = new Stack<>(); /* Hold the current stack. */
        private Stack<Integer> minimumStack = new Stack<>(); /* Hold the minimum stack. */

        public void push(int data) throws Exception { /* Pushes into the minStack. */
            
            int min = data;    
            
            if (!minimumStack.isEmpty()) {        /* For every push() We peek inside the minStack as long as is not empty. */     
                if (min > minimumStack.peek()) {  /* If data is greater then the top of minStack. */ 
                    min = minimumStack.peek();    /* Then, minValue remains as the peek in the min stack. */
                }
            }
            System.out.println("Min: "+min);
            System.out.println("data: "+data);
            stack.push(data);                     /* Push value to stack. */
            minimumStack.push(min);               /* Push value to Minimum stack. */
        }

        public int pop() throws Exception {
            minimumStack.pop();                   /* pop Value from minStack */
            return stack.pop();                   /* return and pop the original stack. */
        }

        public int getMinimum() throws Exception {
            return minimumStack.peek();           /* Returns the value in the top of the MinStack.*/
        }
    }
}



