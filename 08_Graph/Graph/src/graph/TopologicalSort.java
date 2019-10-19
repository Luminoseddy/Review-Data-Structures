/**
 * A valid topological sort: Must visit all nodes once.
 * 
 * Its an ordering of vertices in a directed acyclic graph in which each 
 * node comes before all the nodes to which it has outgoing edges. 
 * 
 * A -> B    : A should come before b. 
 * Ex. Withdraw money first before buying something from the store. 
 *     Where A, must by money first: B, buy something from the store. 
 * 
 * Time Complexity: 
 *      O( V + E) : Every edge and vertex is visited once. 
 * 
 */
package graph;

import java.util.*;

public class TopologicalSort  {
    
//    @Override
//    public int getIndegree(int v){
//        if (v < 0 || v >= numVertices){ 
//            throw new IllegalArgumentException("Vertex number not valid.");
//        }
//        int indegree = 0;
//        for(int i = 0; i < getNumVertices(); i++){
//            if(adjacencyMatrix[i][v] != 0){
//                indegree++;
//            }
//        }
//    }
    
    public static List<Integer> sort(Graph graph){
        
        LinkedList<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> indegreeMap = new HashMap<>(); /* Set up the inDegree mapping of a vertex to its indegree. */

        /* It initiliazes the in degree map by iterating through all vertices. And finding the indegree of every vertex.  */
        for (int vertex = 0; vertex < graph.getNumVertices(); vertex++) {
            int indegree = graph.getIndegree(vertex);
            indegreeMap.put(vertex, indegree);
            
            /* As we iterate through the vertex, if it has indegree 0, we add it to the queue. */
            if (indegree == 0) {
                queue.add(vertex);
            }
        }

        /* For every eleement we pull from the queue, that element is added to the topological sort list */
        List<Integer> sortedList = new ArrayList<>();
        while (!queue.isEmpty()){
            /* Dequeue of the nodes from the list if there are more than one.
             * If more than one element exists then it means that the graph
             * has more than one topological sort solution. */ 
            int vertex = queue.pollLast();
            sortedList.add(vertex);
         
            /* Access the adjacent verticy of the element that we just added to the sorted list.  */
            List<Integer> adjacentVertices = graph.getAdjacentVertices(vertex);
            for (int adjacentVertex : adjacentVertices) {
                
                /* Every adjacent vertex we reduce its indegree by 1. */ 
                int updatedIndegree = indegreeMap.get(adjacentVertex) - 1;
                indegreeMap.remove(adjacentVertex);
                indegreeMap.put(adjacentVertex, updatedIndegree);

                /* Every vertext which has a indegree 0, its a potential next node for the topological sort. */
                if (updatedIndegree == 0) {
                    queue.add(adjacentVertex);
                }
            }
        }

        /* If the final sorted list is not equal to the number of vertices in the graph, then theres a cycle. */
        if (sortedList.size() != graph.getNumVertices()) {
            throw new RuntimeException("The Graph had a cycle!");
        }

        return  sortedList;
    }
 

    public static void main(String[] args) {
        
        Graph graph1 = new AdjacencyMatrixGraph(8, Graph.GraphType.DIRECTED);
        
        graph1.addEdge(2, 7);
        graph1.addEdge(0, 3);
        graph1.addEdge(0, 4);
        graph1.addEdge(0, 1);
        graph1.addEdge(2, 1);
        graph1.addEdge(1, 3);
        graph1.addEdge(3, 5);
        graph1.addEdge(3, 6);
        graph1.addEdge(4, 7);

        printList(sort(graph1));
    }

    public static void printList(List<Integer> list) {
        for (int v : list) {
            System.out.println(v + ", ");
        }
    }

}
