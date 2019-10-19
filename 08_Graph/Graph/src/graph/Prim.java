/**
 * Time Complexity: 
 *          O(ElogV) : IF binary heaps are used for priority queue.
 *          O(E+V*V) : IF array is used for priority queue.
 * 
 * Minimum spanning tree is a subgraph that contains all the vertices.
 * 
 * You generate the distance table using Dijkstra algorithm using any vertex as source. 
 * 
 * DISTANCE [NEIGHBOUR] = WEIGHT OF EDGE [VERTEX,NEIGHBOUR]
 * 
 * Only worry about the weight of the edge, not the cumulative distance from the source
 * 
 * The edge is chosen to be part of the spanning tree IF:
 *      - The vertex is closest vertex at the current step. (connected by lowest weight)
 *      - The vertex is not part of the spanning tree already. 
 * 
 * We explore more edges than vertices in this Algorithm.
 * 
 */
package graph;

import javafx.util.Pair;

import java.util.*;

public class Prim {

    public static void main(String[] args) {
        Graph graph1 = new AdjacencyMatrixGraph(8, Graph.GraphType.UNDIRECTED);
        graph1.addEdge(2, 7, 4);
        graph1.addEdge(0, 3, 2);
        graph1.addEdge(0, 4, 2);
        graph1.addEdge(0, 1, 1);
        graph1.addEdge(2, 1, 3);
        graph1.addEdge(1, 3, 2);
        graph1.addEdge(3, 5, 1);
        graph1.addEdge(3, 6, 3);
        graph1.addEdge(4, 7, 22);
        graph1.addEdge(7, 5, 4);

        spanningTree(graph1, 0);
    }

    
    
    
    
    public static void spanningTree(Graph graph, int source) {
        
        /**
         * Start with any source, set up the distance table and priority queue, 
         * it that returns nodes in order from the shortest distance from the source (greedy solution). 
         * 
         * The distance from the source here is the distance from the last edge connected to that vertex
         * (Which thats the difference between the Dijkstra and Prim algorithm).
         * 
         */
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
        PriorityQueue<VertexInfo> queue = new PriorityQueue<>(new Comparator<VertexInfo>() {
            @Override
            public int compare(VertexInfo v1, VertexInfo v2) {
                return ((Integer) v1.getDistance()).compareTo(v2.getDistance());
            }
        });

        /* Initialize the distance table for every vertex(node) in the graph. */
        for (int j = 0; j < graph.getNumVertices(); j++) {
            distanceTable.put(j, new DistanceInfo());
        }

        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);

        Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();

        /* Set up the vertex info for the source, and add it to the priorty queue.
         * Also set up the mapping for the vertex info for every vertex. */
        VertexInfo sourceVertexInfo = new VertexInfo(source, 0);
        queue.add(sourceVertexInfo);
        vertexInfoMap.put(source, sourceVertexInfo);

        /* Set of edges, connects all nodes of th graph, is a string presented by 0 or 1. */  
        Set<String> spanningTree = new HashSet<>();
        Set<Integer> visitedVertices = new HashSet<>();

        while (!queue.isEmpty()) {
            /* We've seeded the queue into the VertexInfo. */
            /* Poll the queue to find the highest priority vertex. (shortest distance). */
             
            VertexInfo vertexInfo = queue.poll();
            int currentVertex = vertexInfo.getVertexId();
   
            /* Every time we see the vertex, it must be something that hasn't visited yet. 
             * If we've seen it, continue and don't process it. */
            if (visitedVertices.contains(currentVertex)) { continue; }
                
            visitedVertices.add(currentVertex);

            /* If the current vertex is a source we do not have an edge yet. */
            if (currentVertex != source) {
                String edge = String.valueOf(currentVertex)
                        + String.valueOf(distanceTable.get(currentVertex).getLastVertex());
                if (!spanningTree.contains(edge)) {
                    spanningTree.add(edge);
                }
            }

            for (Integer neighbour : graph.getAdjacentVertices(currentVertex)) {
                int distance = graph.getWeightedEdge(currentVertex, neighbour);

                /* If we find a new shortest path to the neighbor update the distance and the last vertex.*/        
                if (distanceTable.get(neighbour).getDistance() > distance) {
                    
                    distanceTable.get(neighbour).setDistance(distance);
                    distanceTable.get(neighbour).setLastVertex(currentVertex);
                    VertexInfo neighbourVertexInfo = vertexInfoMap.get(neighbour);
                    if (neighbourVertexInfo != null) { queue.remove(neighbourVertexInfo); }
                      
                    neighbourVertexInfo = new VertexInfo(neighbour, distance);
                    vertexInfoMap.put(neighbour,neighbourVertexInfo);
                    queue.add(neighbourVertexInfo);
                }
            }
        }

        for (String edge : spanningTree) {
            System.out.println(edge);
        }
    }

    /**
     * A class which holds the distance information of any vertex.
     * The distance specified is the distance from the source node
     * and the last vertex is the last vertex just before the current
     * one while traversing from the source node.
     * 
     * The data structure is the same, but the way we use it is different. 
     */
    public static class DistanceInfo {

        private int distance; 
        private int lastVertex;

        public DistanceInfo() {
            // The initial distance to all nodes is assumed
            // infinite.
            distance = Integer.MAX_VALUE;
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
     * the edge that leads to that vertex from its neighbor
     */

    public static class VertexInfo {

        private int vertexId; /* Track evey vertex id. */
        private int distance; /* And current distance from that source. */

        public VertexInfo(int vertexId, int distance) {
            this.vertexId = vertexId;
            this.distance = this.distance;
        }

        public int getVertexId() {
            return vertexId;
        }

        public int getDistance() {
            return distance;
        }
    }

}



