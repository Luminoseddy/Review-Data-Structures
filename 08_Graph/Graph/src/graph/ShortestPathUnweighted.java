/**
 * Shortest Path Algorithms
 * 
 * Time Complexity: 
 *      Adjacent List:   O(V+E) : #of vertices + #of edges, accessing every vertex and edge exactly once. 
 *                                Because in this we can find out instantly what the neighboring vertices are.
 * 
 *      Adjacent Matrix: O(V^2) : In matrix, we have to check all vertices to see if a vertex is adjacent to another. 
 *                                For every vertex, we  check every other vertex and confirm if its adjacent. 
 * 
 */
package graph;
import java.util.*;

public class ShortestPathUnweighted {


    public static void main(String[] args) {
        Graph graph1 = new AdjacencyMatrixGraph(8, Graph.GraphType.DIRECTED);
        graph1.addEdge(2, 7);
        graph1.addEdge(3, 0);
        graph1.addEdge(0, 4);
        graph1.addEdge(0, 1);
        graph1.addEdge(2, 1);
        graph1.addEdge(1, 3);
        graph1.addEdge(3, 5);
        graph1.addEdge(6, 3);
        graph1.addEdge(4, 7);

        shortestPath(graph1, 1, 7);
    }

    
    /* Build the distance table */
    private static Map<Integer, DistanceInfo> buildDistanceTable(Graph graph, int source) {
        
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
        
        /* Initialize the distance table with an entry for every vertex. 
         * Iterate through all the vertices in the grpah and then add an entry to 
         * the distance table for every vertex.  */
        for (int j = 0; j < graph.getNumVertices(); j++) {
            distanceTable.put(j, new DistanceInfo());
        }

        /* In the distance table. Set distance of the source from tiself to 0 */
        distanceTable.get(source).setDistance(0);
        
        /* Set the last vertex to the source.  */
        distanceTable.get(source).setLastVertex(source);

        LinkedList<Integer> queue = new LinkedList<>(); 
        queue.add(source); /* Add the source of the BFS to the queue */

        /* Pull the vertices from the queue, and explore their neighbors. */
        while (!queue.isEmpty()) {
            int currentVertex = queue.pollFirst();
            
            for (int i : graph.getAdjacentVertices(currentVertex)) {
                int currentDistance = distanceTable.get(i).getDistance();
                
                /* If one of the adj vertices is a vertext thats been seen for the first time, 
                 * then update the entry in the distance table for that vertex. */
                if (currentDistance == -1) {
                    currentDistance = 1 + distanceTable.get(currentVertex).getDistance();
                    distanceTable.get(i).setDistance(currentDistance);
                    distanceTable.get(i).setLastVertex(currentVertex);
                    
                    /* If they have neightbors then update the disstance table. 
                     *  Enqueue the neighbour only if it has other adjacent vertices. */
                    if (!graph.getAdjacentVertices(1).isEmpty()) {
                        queue.add(i);
                    }
                }
            }
        }
        return distanceTable;
    }

    
    public static void shortestPath(Graph graph, int source, int destination) {
        
        /* Build the distance table for the entire graph. */
        Map<Integer, DistanceInfo> distanceTable = buildDistanceTable(graph, source);

        /* Back track using a stack, staarting from destination node. */
        Stack<Integer> stack = new Stack<>();
        stack.push(destination);

        int previousVertex = distanceTable.get(destination).getLastVertex();
        
        /* Backtrace from destination node to the source node using the last vertex entry in the ditance table 
         * Pull out every vertex. and push it to the stack. */
        while (previousVertex != -1 && previousVertex != source) {
            stack.push(previousVertex);
            previousVertex = distanceTable.get(previousVertex).getLastVertex();
        }

        /* If at any point, the last vertex for any entry is -1, meaning no valid last 
         * vertex is present from the source to that vertex. then the path does not exist.  */
        if (previousVertex == -1) {
            System.out.println("There is no path from node: " + source
                    + " to node: " + destination);
        }
        else {
            System.out.print("Smallest path is " + source);
            /* Pop all the elements from the stack and then print the shortest path from source to destination. */
            while (!stack.isEmpty()) {
                System.out.print(" -> " +stack.pop()); 
            }
            System.out.println(" Shortest Path Unweighted DONE!");
        }
    }

    /**
     * A class which holds the distance information of any vertex.
     * The distance specified is the distance from the source node
     * and the last vertex is the last vertex just before the current
     * one while traversing from the source node.
     */
    
    /* Distance Table data Structure. */
    public static class DistanceInfo {

        private int distance;   /* distance from the vertex from the source. */
        private int lastVertex; /*Last vertex in the path from the source. */

        public DistanceInfo() {
            distance = -1;
            lastVertex = -1;
        }

        /* HELPER METHODS. */
        public int getDistance() {
            return distance;
        }

        public int getLastVertex() {
            return lastVertex;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public void setLastVertex(int lastVertex) {
            this.lastVertex = lastVertex;
        }
    }
}

