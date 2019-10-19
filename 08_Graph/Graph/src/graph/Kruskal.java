/**
 * TIME COMPLEXITY:
 *          E(logE)
 * 
 * 
 * Finds the minimum spanning tree for forests (unconnected graphs)
 * Uses GREEDY ALGORITHM.
 * 
 * 1. Use a priority queue of edges where the weights of the edges determine the priority 
 *    of the edge. 
 * 
 * 2. While adding a new edge, always make sure that the new edge does not create a cycle
 *    in the spanning tree.
 */
package graph;

import java.util.*;


public class Kruskal {

    public static void main(String[] args) {
        Graph graph1 = new AdjacencyMatrixGraph(9, Graph.GraphType.UNDIRECTED);
        graph1.addEdge(2, 7, 4);
        graph1.addEdge(0, 3, 2);
        graph1.addEdge(0, 4, 2);
        graph1.addEdge(0, 1, 1);
        graph1.addEdge(2, 1, 3);
        graph1.addEdge(1, 3, 2);
        graph1.addEdge(3, 5, 3);
        graph1.addEdge(3, 6, 2);
        graph1.addEdge(4, 7, 22);
        graph1.addEdge(7, 5, 4);
        graph1.addEdge(6, 5, 1);

        spanningTree(graph1);
    }

    static void spanningTree(Graph graph) {

        /* Setting up the spanning tree.  
         * A priority queue to store and retrieve the edges on the basis of their weights. 
         */
        PriorityQueue<EdgeInfo> queue = new PriorityQueue<>(new Comparator <EdgeInfo> () {
            @Override
            public int compare(EdgeInfo o1, EdgeInfo o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        /* Explore the entire graph, Find all the edges, 
         * and add all edges in edgeInfos into the priority queue. */
        for (int i= 0; i < graph.getNumVertices(); i++) {
            for (int neighbour : graph.getAdjacentVertices(i)) {
                queue.add(new EdgeInfo(i, neighbour, graph.getWeightedEdge(i, neighbour)));
            }
        }

        /* Holds the set of vertices we have visited. (Keeps track). 
         * We use the set to check if the minimal spanning tree of the graph actually exist. */
        Set<Integer> visitedVertices = new HashSet<>();
         
        /* Spanning tree is a se of edge infos Includes all edges that form the spaning tree for the iteration. 
         * At the end it'll contain the minimal spanning tree. */     
        Set<EdgeInfo> spanningTree = new HashSet<>(); 
        Map<Integer, Set<Integer>> edgeMap = new HashMap<>();
        
        for (int v = 0; v < graph.getNumVertices(); v++) {
            /* EdgeMap is a data structure: that tracks the edges added to the spanning tree. and to see 
             * if it forms a cycle. The edge is added to the span tree only if it doesn't form a cycle with 
             * the existening edges in the spanning tree. */
            edgeMap.put(v, new HashSet<>());
        }
        
        /* Iterate over the edges, as long as there is an edge to visit. */
        while(!queue.isEmpty() && spanningTree.size() < graph.getNumVertices() - 1) {
            /* Get the edge with the smallest edge. */
            EdgeInfo currentEdge = queue.poll();

            /* Pick the edge with lowest weight and then check
             * wether adding the edge to the spanning tree will cause a cycle. */
            edgeMap.get(currentEdge.getVertex1()).add(currentEdge.getVertex2());
            
            if (hasCycle(edgeMap)) {
                edgeMap.get(currentEdge.getVertex1()).remove(currentEdge.getVertex2());
                continue;
            }
            /* If no cycle, add the edge to the spanning tree. */
            spanningTree.add(currentEdge);

           /* Add both vertices that connect the edge to the visited verticies list.
            * The list is what we use to check if we have a minimal spanning tree at the end of the loop. */
            visitedVertices.add(currentEdge.getVertex1());
            visitedVertices.add(currentEdge.getVertex2());
        }

        /* After while loop ends, check wether all vertices have been covered. 
         * If yes then spanning tree exist. */
        if (visitedVertices.size() != graph.getNumVertices()) {
            System.out.println("Minimum Spanning Tree is not possible");
        } else {
            System.out.println("Minimum Spanning Tree using Kruskal's Algorithm");
             
            for(EdgeInfo edgeInfo : spanningTree ) {
                System.out.println(edgeInfo);
            }
        }
    }

    /* Takes in the edgeMap thats been created 
        Contains all other edges that are present in the spanning tree */
    private static boolean hasCycle(Map<Integer, Set<Integer>> edgeMap) {
        
        /* Iterate through all the vertex in the keys of the edge map, 
         * (every vetex thats present in the spanning tree) 
         * Starting from every vertex, find all verticies that are connected 
         * to it in the spanning tree and see if theres a cycle */
        for (Integer sourceVertex : edgeMap.keySet()) {
            
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(sourceVertex);
            Set<Integer> visitedVertices = new HashSet<>();
           
            while (!queue.isEmpty()) {
                int currentVertex = queue.pollFirst();
                
                /* If we revisit a vertex that we have seen, it means theres a cycle in the tree.   */
                if (visitedVertices.contains(currentVertex)) {
                    return true;
                }

                /* Keep populating the queue. */
                visitedVertices.add(currentVertex);
                queue.addAll(edgeMap.get(currentVertex));
            }
        }

        return false;
    }

    /* A class which represents an edge in an undirected weighted graph. */
    public static class EdgeInfo {

        /* Represent an edge with these 3 variables. */
        private Integer vertex1;
        private Integer vertex2;
        private Integer weight;

        public EdgeInfo(Integer vertex1,Integer vertex2, Integer weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }

        public Integer getVertex1() {
            return vertex1;
        }

        public Integer getVertex2() {
            return vertex2;
        }

        public Integer getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            /* Get the string representation of the edge. */
            return String.valueOf(vertex1) + String.valueOf(vertex2);
        }
    }
}
