/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverselinkedlist;

/**
 *
 * @author edward
 */
public class ReverseLinkedList {

    private ReverseLinkedList next;

    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public ReverseLinkedList reverseList(ReverseLinkedList head) {
        
        ReverseLinkedList prev = null;
        ReverseLinkedList curr = head;
        ReverseLinkedList next = null;
        
        while(curr != null){
            
            
            next = curr.next; // we save the next node, into next b/c if we change curr.next val, we loose the value on next iteratoin.
            curr.next = prev; // reverse, point the node to its previous <-
            prev = curr;      // prev node becoems the node we're sitting on
            curr = next;  // curr node becomes the node we saved.
        }
        return prev; // return the prev which is pointing at the head.
    }
    // 
    // null->1->2->3->4->null
    // null <-1 2 

    
}
