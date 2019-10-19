/**
 * TIME COMPLEXITY: 
 *                  O(ElogV) : Only if the binary heaps are used for priority queues.
 *                  O(E+V^2) : If array is used for priority queue.
 * 
 * Dijkstra's Algorithm: Finding the shortest path in a weighted graph. 
 *  
 * 3 MAJOR differences:   
 *      1. The distance from a node now has to account for the weight of edges traversed.
 *         Distance[neighbor] = distance[vertex] + weight of edge[vertex, neighbor]
 *         initialize all the distance to infinite instead of -1. 
 * 
 *      2. Weighted graphs visit the neighbor with the lowest weight. 
 *         Each vertex has neighbors. Use Priority Queue.
 *         To get the next vertex in the path, pop the element with the lowest weight. (Greedy Algorithm.)
 *         Greedy algorithms are good for optimization problems. (Dijkstra is also greedy type algorithm
 *         Greedy solutions are useful to find approx solutions to very hard problems.
 *         Ex. Traveling salesman problem. 
 * 
 *      3. Possible to visit vertex more than once. 
 *         Check if new distance is smaller than old distance.
 *         RELAXATION: Rewriting the distance and the path to vertex.
 * 
 */

 

package graph;

import java.util.*;

public class Dijkstra {

    public static void main(String[] args) {
        Graph graph1 = new AdjacencyMatrixGraph(8, Graph.GraphType.DIRECTED);
        
        graph1.addEdge(2, 7, 4);
        graph1.addEdge(0, 3, 2);
        graph1.addEdge(0, 4, 2);
        graph1.addEdge(0, 1, 1);
        graph1.addEdge(2, 1, 3);
        graph1.addEdge(1, 3, 2);
        graph1.addEdge(3, 5, 1);
        graph1.addEdge(3, 6, 3);
        graph1.addEdge(4, 7, 2);
        graph1.addEdge(7, 5, 4);

        shortestPath(graph1, 0, 5);
    }


    public static Map<Integer, DistanceInfo> buildDistanceTable(Graph graph, int source) {
        
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
        
        /* Set up the priority queue, and using the GREEDY ALGORITHM, 
         * it returns all the nodes in the order of the shortest distance from the source. */
        PriorityQueue<VertexInfo> queue = new PriorityQueue<>(new Comparator<VertexInfo>() {
            @Override
            public int compare(VertexInfo v1, VertexInfo v2) {
                return ((Integer) v1.getDistance()).compareTo(v2.getDistance());
            }
        });
        
        
        Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();
        
        /* Initialize the distance table, the row of every vertex for the ditance table,
         * and add a distance table entry for each node in the graph. */
        for (int j = 0; j < graph.getNumVertices(); j++) {
            distanceTable.put(j, new DistanceInfo());
        }

        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);

        VertexInfo sourceVertexInfo = new VertexInfo(source, 0);
        
        /* Add the source to the priority queue and set up a mapping to the vertex info
         * for every vertex in the queue. */
        queue.add(sourceVertexInfo);
        vertexInfoMap.put(source, sourceVertexInfo);

        while (!queue.isEmpty()) {
            
            /* First dequeue or remove the closest vertex, and at any point we want that vertex whos distance is the smallest. 
             * We use the priority queue. */
            VertexInfo vertexInfo = queue.poll();
            int currentVertex = vertexInfo.getVertexId();

            /* Once we have that vertex we iterate through all the neighbors of that queue. */ 
            for (Integer neighbour : graph.getAdjacentVertices(currentVertex)) {
                
                /* New distance to the new vertex  is the distance of current vertex + the weighted edge that conects the vertetex to its neighbor . */
                int distance = distanceTable.get(currentVertex).getDistance()
                        + graph.getWeightedEdge(currentVertex, neighbour);

                /* Once we get the distance to the neighbor, we check if the new path distance is 
                 * shorter than the currently existing path. and update the distance table. */
                if (distanceTable.get(neighbour).getDistance() > distance) {
                    distanceTable.get(neighbour).setDistance(distance);
                    distanceTable.get(neighbour).setLastVertex(currentVertex);

                    /* */
                    VertexInfo neighbourVertexInfo = vertexInfoMap.get(neighbour);
                    
                    /* REMOVE THE OUTDATED VERTEX PATH INFORMATION FROM THE QUEUE - WE HAVE A NEW SHORTER ROUTE */
                    if (neighbourVertexInfo != null) { queue.remove(neighbourVertexInfo); }
                        
                    /* Add the neighbour back with a new updated distance. */
                    neighbourVertexInfo = new VertexInfo(neighbour, distance);
                    queue.add(neighbourVertexInfo);
                    vertexInfoMap.put(neighbour, neighbourVertexInfo);
                }
            }
        }
        return distanceTable;
    }

    
    
    
    public static void shortestPath(Graph graph, Integer source, Integer destination) {
        
        /* Builds th distance table of the entire graph. */
        Map<Integer, DistanceInfo> distanceTable = buildDistanceTable(graph, source);

        /* Allows us to back track from the destination node. */
        Stack<Integer> stack = new Stack<>();
        stack.push(destination);

        /* Backtrack by getting the last vertex of every node and adding it to the stack. */
        int previousVertex = distanceTable.get(destination).getLastVertex();
        
        while (previousVertex != -1 && previousVertex != source) {
            stack.push(previousVertex);
            previousVertex = distanceTable.get(previousVertex).getLastVertex();
        }

        /* If no valid last vertex was found in the idstance table. */
        if (previousVertex == -1) {
            System.out.println("There is no path from node: " + source
                    + " to node: " + destination);
        }
        else {
            System.out.print("Smallest Path is " + source);
            while (!stack.isEmpty()) {
                System.out.print(" -> " +stack.pop());
            }
            System.out.println(" Dijkstra  DONE!");
        }
    }

    /**
     * A class which holds the distance information of any vertex.
     * The distance specified is the distance from the source node
     * and the last vertex is the last vertex just before the current
     * one while traversing from the source node.
     */
    public static class DistanceInfo {
        
        private int distance;  /* Distance table stores the distance to the vertext from the source. */
        private int lastVertex;/* Holds the last vertex in the path from the current vertex. */

        public DistanceInfo() {
            
            distance = Integer.MAX_VALUE; /* Initially setting this to inifnite. Eventually they'll be updated. */
            lastVertex = -1;
        }

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


    /**
     * A simple class which holds the vertex id and the weight of
     * the edge that leads to that vertex from its neighbor.
     * 
     * This is a Data Structure that we use. 
     */
    public static class VertexInfo {

        private int vertexId; /* Track evey vertex id. */
        private int distance; /* And current distance from that source. */

        public VertexInfo(int vertexId, int distance) {
            this.vertexId = vertexId;
            this.distance = distance;
        }

        public int getVertexId() {
            return vertexId;
        }

        public int getDistance() {
            return distance;
        }
    }
}
