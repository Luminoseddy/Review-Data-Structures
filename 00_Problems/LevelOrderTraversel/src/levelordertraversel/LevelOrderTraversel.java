/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package levelordertraversel;

import java.util.LinkedList; 
import java.util.Queue; 
  
public class LevelOrderTraversel
{ 
    // A Binary Tree Node 
    static class Node 
    { 
        int data; 
        Node left; 
        Node right; 
          
        // constructor 
        Node(int data){ 
            this.data = data; 
            left = null; 
            right =null; 
        } 
    } 
      
    // Iterative method to do level order traversal line by line 
    static void printLevelOrder(Node root) 
    { 
        // Base Case 
        if(root == null) 
            return; 
          
        // Create an empty queue for level order tarversal 
        Queue<Node> q =new LinkedList<Node>(); 
          
        // Enqueue Root and initialize height 
        q.add(root); 
 
        while(true) 
        { 
              
            // nodeCount (queue size) indicates number of nodes 
            // at current level. 
            int nodeCount = q.size(); 
            if(nodeCount == 0) 
                break; 
              
            // Dequeue all nodes of current level and Enqueue all 
            // nodes of next level 
            while(nodeCount > 0) 
            { 
                Node node = q.peek(); 
                System.out.println("Peeking inside " +node.data); 
                
                q.remove(); 
                System.out.println("Removed from linked list " +node.data); 
                
                if(node.left != null) {
                    System.out.println("Left node from pervious parent? " +node.data); 
                    q.add(node.left); 
                }
                
                if(node.right != null) {
                    q.add(node.right); 
                }
                    
                nodeCount--; 
            } 
            System.out.println(); 
        } 
    } 
      
    // Driver program to test above functions 
    public static void main(String[] args)  
    { 
        // Let us create binary tree shown in above diagram 
       /*               1 
                   /     \ 
                  2       3 
                /   \       \ 
               4     5       6 
        */
          
        Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.right = new Node(6); 
          
        printLevelOrder(root); 
  
    } 
  
} 
