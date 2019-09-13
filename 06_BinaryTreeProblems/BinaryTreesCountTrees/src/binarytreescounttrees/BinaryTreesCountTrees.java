package binarytreescounttrees;

public class BinaryTreesCountTrees {

    public static void main(String[] args) {

//        System.out.println("Tree count for 1 node: " + countTrees(1));
//        System.out.println("Tree count for 2 nodes: " + countTrees(2));
        System.out.println("Tree count for 3 nodes: " + countTrees(3));
//        System.out.println("Tree count for 6 nodes: " + countTrees(6));
    }

    
    /* Takes in the number of nodes the tree contains. */
    public static int countTrees(int numNodes) {
        
        /* Base case. */
        /* Return 1 if input is <= 1. Meaning is the root of tree, or null. */
        if (numNodes <= 1) { return 1; }
           
        int sum = 0;
        
        /* Consider that evey node can be the root. */
        for (int i = 1; i <= numNodes; i++) {
            
            int countLeftTrees = countTrees(i - 1);
            int countRightTrees = countTrees(numNodes - i);

            
            System.out.println("cycle: " + i+" countLeftTrees "  + countLeftTrees+" countRightTrees " + countRightTrees);
            
            /* Number of possible trees with this root, combination of right and left subtrees. */
            sum = sum + (countLeftTrees * countRightTrees);
            
            System.out.println("sum: " + sum);
            
        }

        return sum;
    }
}
