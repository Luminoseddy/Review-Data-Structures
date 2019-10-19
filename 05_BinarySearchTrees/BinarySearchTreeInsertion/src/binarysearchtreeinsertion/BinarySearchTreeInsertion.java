/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtreeinsertion;

public class BinarySearchTreeInsertion {


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

        insert(head, one);
        insert(head, seven);
        insert(head, three);
        insert(head, eight);
        insert(head, two);
        insert(head, nine);
        insert(head, six);
        insert(head, four);

        inOrder(head);
    }

    public static void print(Node node) {
        System.out.print(node.getData() + "->");
    }

    public static void inOrder(Node root) {
        
        /* Base case. */
        if (root == null) { return; }
            
        inOrder(root.getLeftChild());
        print(root);
        inOrder(root.getRightChild());
    }

    public static Node<Integer> insert(Node<Integer> head, Node<Integer> node) {
        
        /* Base case: IF() then the node itself is the head. */
        if (head == null) { return node; }
            
        /* If the node is less than the head, then its somewhere on the left subTree. 
           If theres no leftChild, then its simply insrted. 
           Recursively insert. */
        if (node.getData() <= head.getData()) {
            head.setLeftChild(insert(head.getLeftChild(), node));
        } else {
            head.setRightChild(insert(head.getRightChild(), node));
        }
        
        return head;
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

