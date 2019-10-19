
package linkedlist;

// customer faceing applicatoins 

/**
 *                       LINKED LIST                         VS                                 ARRAY LIST
 * -------------------------------------------------------------------------------------------------------------------------------------------- *    
 *                          PROS                             | *                                   CONS                                         *
 * ----------------------------------------------------------| * ------------------------------------------------------------------------------ *
 * Unlimited in size.                                        | * Arrays must be declared up front.                                              *
 * Grows dynamically.                                        | * Cannot increase dynamically.                                                   *
 *                                                           | *                                                                                *
 * Inserting a new E is easy, and the logicalNext            | * Arrays are located in contiguous memory locations.                             *
   pointer have to be reassigned (not complex).              | * To insert an E the E's to its right must move and make room for it.            *
 *                                                           | * Heavy weight operation.                                                        *
 * Same with deleting an E.                                  | * Same with deleting the E in the array.                                         * 
 *                                                           | *                                                                                *
 * ----------------------------------------------------------| * ------------------------------------------------------------------------------ *      
 *                          CONS                             | *                                  PROS                                          *
 * ----------------------------------------------------------| * ------------------------------------------------------------------------------ *
 * Random access to an E is not possible for                 | * Arrays provide very quick lookUp for E's in specific indices because they are  *
   the entire list up-to that E has to be traversed.         |   contiguous memory locations. We know exactly where in memory the E is.         *
 *                                                           | *                                                                                *
 * Each E requires additional space to store a pointer       | * No extra space is required other than the actual E's which make up the array.  *
   to the next E.                                            | *                                                                                *
 *                                                           | *                                                                                *
 * Can't take advantage of spatial locality (for caching)    | * Because E are in contiguous memory locations, access to arrays takes advantage *
   when accessing E.                                         |   of spatial locality in caches.                                                 *
 * Each E can live anywhere in memory and be pointed to.     | * Significant performance improvement.                                           *
                                                             |                                                                                  *
 * ==========================================================|================================================================================= *
 * USE LINKED LISTS WHEN YOU HAVE A LARGE NUMBER OF INSERT OR| * USE ARRAYS WHEN READ OPERATIONS NEED TO BE EXTREMELY FAST AND                  *
 * DELETE OPERATIONS TO PERFORM.                             | * YOU HAVE RELATIVELY FEW UPDATES TO THE ARRAY                                   *
 *                                                           | *                                                                                *
 * YOU HAVE NO IDEA HOW LARGE YOUR LIST MIGHT BE             | * YOU REQUIRE RANDOM ACCESS TO ARRAY ELEMENTS                                    *
 * ==========================================================| * ============================================================================== *
 * 
 **/

public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> n = new LinkedList<Integer>();
        System.out.println("Adding nodes, CurrentList" );
        n.addNode(3);
        n.addNode(4);
        n.addNode(5);
        n.addNode(10);     
        n.printNodes(); //  to print all the nodes

        System.out.println("\ncountNodes(): " + n.countNodes());
        System.out.println("popElement(), now we have: " + n.popElement());
//        System.out.println("Printing all nodes through printnode function after pop function" );
        n.printNodes();

        System.out.println("\nInsert in the Nth position: ");
        n.insertNth(0, 3);
        n.insertNth(4, 12);
        n.insertNth(4, 31);
        n.insertNth(4, 40);
        n.insertNth(4, 50);
        System.out.println("\nAfter insert Nth position:" );
        n.printNodes();

//        System.out.println("\nInsert Sorted: ");
        n.insertSorted(3);
        n.insertSorted(14);
        n.insertSorted(14);
        n.insertSorted(7);
        System.out.println("\nAfter insertsorted function" );
        n.printNodes();
//
//        // After removing duplicates
//        n.removeDuplicates();
//        System.out.println("\nPrinting all nodes through printnode function after removeDuplicate function" );
//        n.printNodes();
//
//
//        LinkedList<Integer> n1 = new LinkedList<Integer>();
//        n1.addNode(500);
//        n1.addNode(600);
//        n1.addNode(700);
//
//        n.appendList(n1);
//        System.out.println("Printing all nodes through printnode function after append_list function" );
//        n.printNodes();
//
//        n.changeHead(n1);
//        System.out.println("Printing all nodes through printnode function after changeHead function" );
//        n1.printNodes();
//        n.printNodes();
//
        n.reverseList();
        System.out.println("Reverse the linkedList. " );
        n.printNodes();
//        n.reverseList();
//
//        LinkedList<Integer> mergesort = n.sortedMergeList(n1);
//        System.out.println("Printing all nodes through printnode function after mergesorted function" );
//        mergesort.printNodes();
//
//        List<Node<Integer>> frontBackSplit = n.frontBackSplit();
//
//        System.out.println("Printing all nodes through printnode function of Front Split after frontBackSplit function" );
//        printNode(frontBackSplit.get(0));
//
//        System.out.println("Printing all nodes through printnode function of Back Split after frontBackSplit function" );
//        printNode(frontBackSplit.get(1));
    }


    static void printNode(Node head)
    {
        Node curr = null;
        curr = head;
        int i = 1;
        while (curr!= null)
        {
            System.out.println("this is the Node number " + i + ", the value it stores is "+ curr.toString() );
            curr = curr.getNext();
            i++;
        }

    }
}
