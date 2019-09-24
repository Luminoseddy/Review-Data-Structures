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

    public ReverseLinkedList(int par) {}
    


    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public ReverseLinkedList reverseBetween(ReverseLinkedList head, int m, int n) {
        
        if(m==n) return head;

        ReverseLinkedList prev = null;                       // track (m-1)th node
        ReverseLinkedList first = new ReverseLinkedList(0);  // first's next points to mth
        ReverseLinkedList second = new ReverseLinkedList(0); // second's next points to (n+1)th

        int i=0;
        ReverseLinkedList p = head;
        
        while(p!=null){
            i++;
            if(i==m-1){
                prev = p;
            }

            if(i==m){
                first.next = p;
            }

            if(i==n){
                second.next = p.next;
                p.next = null;
            }

            p= p.next;
        }
        if(first.next == null)
            return head;

        // reverse list [m, n]    
        ReverseLinkedList p1 = first.next;
        ReverseLinkedList p2 = p1.next;
        p1.next = second.next;

        while(p1!=null && p2!=null){
            ReverseLinkedList t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }

        //connect to previous part
        if(prev!=null)
            prev.next = p1;
        else
            return p1;

        return head;
}
    
}
