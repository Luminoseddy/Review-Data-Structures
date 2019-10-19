package binarytreeinordertraversal;
public class BinaryTreeInOrderTraversal {

    /* IN-ORDER traversal:
     * Starts from the most left possible node (if its left subtree), continues until it hits the root 
     *    
     * Then it processes right and then down to its most left node. 
    
            A
           / \
          B   C
             / \      : (B -> A -> F -> D -> H -> C -> E -> G)
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
        Node<Character> x = new Node<>('X');

        a.setLeftChild(b);
        a.setRightChild(c);
        c.setLeftChild(d);
        c.setRightChild(e);
        d.setLeftChild(f);
        d.setRightChild(h);
        e.setRightChild(g);
        b.setLeftChild(x);

        inOrder(a);
    }

    public static void print(Node node) {
        System.out.print(node.getData() + "->");
    }

    public static void inOrder(Node root) {
        if (root == null) { return; }
            
        

        inOrder(root.getLeftChild());
        print(root);
        inOrder(root.getRightChild());
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
