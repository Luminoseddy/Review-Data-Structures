/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtreeminimumvalue;

public class BinarySearchTreeMinimumValue {


    public static void main(String[] args) {
        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);
        Node<Integer> six = new Node<>(6);
        Node<Integer> seven = new Node<>(7);
        Node<Integer> eight = new Node<>(8);
        Node<Integer> nine = new Node<>(9);

        Node<Integer> head = insert(null, five);

        insert(head, eight);
        insert(head, two);
        insert(head, one);
        insert(head, seven);
        insert(head, three);
        insert(head, nine);
        insert(head, six);
        insert(head, four);

        System.out.println("Minimum value: " + minimumValue(head));
    }

    public static Node<Integer> insert(Node<Integer> head, Node<Integer> node) {
        
        /* Base case. */
        if (head == null) { return node; }
            
        if (node.getData() <= head.getData()) {
            head.setLeftChild(insert(head.getLeftChild(), node));
        } else {
            head.setRightChild(insert(head.getRightChild(), node));
        }

        return head;
    }

    
    public static int minimumValue(Node<Integer> head) {
        
        /* Base case. If the head is null, then return the the minimum value which was the node itself. 
         * Recall the Integer Class has a function that finds the MIN_VALUE */
        if (head == null) { return Integer.MIN_VALUE; } 
             
        /* As traversing continues recurively, */
        if (head.getLeftChild() == null) {
            return head.getData();
        }

        /* Recursively keep going down the tree till the node has no more left child. 
           Once it reaches the left most node, then we found the min most value, so return. */
        return minimumValue(head.getLeftChild());
    }

    public static class Node<T> {
        private T data;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public Node<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node<T> leftChild) {
            this.leftChild = leftChild;
        }

        public Node<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node<T> rightChild) {
            this.rightChild = rightChild;
        }
    }

}
