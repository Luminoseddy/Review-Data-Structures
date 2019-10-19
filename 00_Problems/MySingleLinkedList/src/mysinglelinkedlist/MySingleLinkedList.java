/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysinglelinkedlist;




/**
 * LinkedList class contains a reference to the node class. 
 */
public class MySingleLinkedList {
     
    public static Node<Object> head; /* First element in the list. */
    public static int theSize;

    public static void main(String[] args) {
        
        MySingleLinkedList list = new MySingleLinkedList();
        
        /* Recall the new node will always be inserted right after the head index. */
        for(Integer i=0; i < 10; i++){
           
         list.add(i);
//         list.print();
        }
        list.print(); 
//        list.contains();
    }
    
    /* Initialize */
    void init(){
        theSize = 0;               /* Start the size with 0. */
        head = new Node<Object>(); /* Set the new node to be the new head. */
        head.next = null;          /* Let the node after the head point to null. */
    }
   
    /* Print the LinkList */
    public static void print(){
        
        Node <Object> p = head;             /* points to the head object. */
        
        while( p != null){                  /* While p does not point to null. */
            System.out.print(p.data + " "); /* Print the current node. */
            p = p.next;                     /* Let p point to the next node. */
        } 
    }
    
    /* Check if the key value is in the link list. Recursively */
    public static boolean contains(Object x) {
           
        if(head==null){
            return false;
        }
        
        Node<Object> p = head;
        
        if(head.next != null){
           p = head.next;
        }
        
        while( p!= null){
            if(x.equals(p.data))
                return true;
            else
                p = p.next;
        }
        return false;
    }
  
    /* Adds the object to the linked list, after the head. */
    public static boolean add (Object x){
        
        if (contains(x))
          return false;
        
        else{
            Node <Object> p = new Node<Object>(x);
            if(head!=null){
                p.next = head.next;
                head.next = p;
            }
            else{
                head = p;
                head.next = null;
            }
            
            theSize++;     
            
        }          
        return true;       
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
    
    
    
    
    /* Check the number of elements. */
    public static int size(){
        return theSize;
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
