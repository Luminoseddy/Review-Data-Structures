package binarytreepreordertraversal;

public class BinaryTreePreOrderTraversal {
    
    /* PRE-ORDER: Must go trough all the left nodes from the root and its children
       before continuing towards the right side of the root. 
    
            A
           / \
          B   C
             / \      : (A -> B -> C -> D -> F -> H -> E -> G)
            D   E
           /\    \
          F  H    G
    
    */
    
    
    public static void main(String[] args) {
        Node<Character> a = new Node<>('A');
        Node<Character> b = new Node<>('B');
        Node<Character> c = new Node<>('C');
        Node<Character> d = new Node<>('D');
        Node<Character> e = new Node<>('E');
        Node<Character> f = new Node<>('F');
        Node<Character> g = new Node<>('G');
        Node<Character> h = new Node<>('H');
//        Node<Character> x = new Node<>('X');

        a.setLeftChild(b);
        a.setRightChild(c);
        c.setLeftChild(d);
        c.setRightChild(e);
        d.setLeftChild(f);
        d.setRightChild(h);
        e.setRightChild(g);
//        b.setLeftChild(x);

        preOrder(a);
    }

    public static void print(Node<Character>node) {
        System.out.print(node.getData() + "->");
    }

    public static void preOrder(Node<Character>root) {
        
        /* Base case */
        if (root == null) {  return; }
        
        print(root);
        
        /* Processes the node before recursing to the left and right subtrees. */
        preOrder(root.getLeftChild());
        preOrder(root.getRightChild());
    }

    public static class Node<T> {
        private T data;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T data) {
            this.data = data;
        }

        public T getData() { return data; }
            
        public Node<T> getLeftChild() { return leftChild; }
            
        public Node<T> getRightChild() { return rightChild; }
            
        public void setLeftChild(Node<T> leftChild) { this.leftChild = leftChild; }
            
        public void setRightChild(Node<T> rightChild) { this.rightChild = rightChild; }
            
        
    }
}
