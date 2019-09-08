/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysinglelinkedlist;

import static org.omg.CORBA.ORB.init;


/**
 * LinkedList class contains a reference to the node class. 
 */
public class MySingleLinkedList {
     
    public static Node<Object> head; /* First element in the list. */
    public static int theSize;
    
   
    public static void main(String[] args) {

        add(1);
        
    }
    
    
    
    
   
    MySingleLinkedList(){
        init();
    }
   
    
    
    
    
    /* Check the number of elements. */
    public static int Size(){
        return theSize;
    }
    
    
    
    
    /* Print the LinkList */
    public static void print(){
        
        Node <Object> p = head.next;
        
        while( p!= null){
            p = p.next;
        }
        
        System.out.println();
    }
    

    
    
    /* Check if the key value is in the link list. Recursively */
    public static boolean contains(Object x) {
           
        Node<Object> p = head.next;
        
        while( p!= null){
            if(x.equals(p.data))
                return true;
            else
                p = p.next;
        }
        return false;
    }
    
    
    
    /* Adds the object to the linked list. : end of the list. (IF its not already in the list)  */
    public static boolean add (Object x){
        
        if (contains(x))
          return false;
        
        else{
            Node <Object> p = new Node<Object>(x);
            p.next = head.next;
            head.next = p;
            theSize++;     
        }          
        return true;       
    }
    
    
    void init(){
        theSize = 0;
        head = new Node<Object>();
        head.next = null;
    }
    

    
    
    /* Removes the object from the linked list. */
    public static boolean remove(Object x){
        
        if(!contains(x))
            return false;
        
        else{
            Node <Object> p = head.next;
            Node <Object> trailer = head;
            
            while (!p.data.equals(x)){
                trailer = p;
                p = p.next;
            }
            trailer.next = p.next;
            theSize--;
        }
        return true;  
    }
    
    /* Seperate class required for the linkedList class.
     * Its made static so that the outter class can access the inner class. */
    public static class Node <Object> {
        
        Node(Object d, Node n){
            data = d;
            next = n;
        }
        
        Node(){
            this(null, null);
        }
        
        Node (Object x){
            this(x, null);
        }

        Object data;
        Node next;     
    }       
    
    
}
