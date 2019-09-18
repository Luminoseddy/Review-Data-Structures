/**
 * 
 */
package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyMatrixGraph implements Graph {

    private int[][] adjacencyMatrix; /* Set up the V x V matrix to hold the vertices and edges relationship. */
    private GraphType graphType = GraphType.DIRECTED; /* Tells us if directed or undirected graph. */
    private int numVertices = 0;

    /**
     * Then initializes the adjacency matrix. 
     * Constructor.Takes in the number of vertices and the type of graph. */
    public AdjacencyMatrixGraph(int numVertices, GraphType graphType) {
        this.numVertices = numVertices;
        this.graphType = graphType;

        adjacencyMatrix = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }
    /**
     * Takes in the source and destination of the vertices.
     * This is an implementation from Graph.
     * 
     * We specify the vertices the edges connect. 
     */  
    @Override
    public void addEdge(int v1, int v2) { 
        /* Check if they're valid vertices. Values between 0 and the number of vertices. */
        if (v1 >= numVertices || v1 < 0 || v2 >= numVertices || v2 < 0) { 
            throw new IllegalArgumentException("Vertex number is not valid");
        }

        adjacencyMatrix[v1][v2] = 1; /* To add a edge, only requires setting row and column to be 1. */
        if (graphType == GraphType.UNDIRECTED) {
            adjacencyMatrix[v2][v1] = 1;
        }
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        
        /* Base case: After getting the vertices of index v, we check if its valid. */
        if (v >= numVertices || v < 0) {
            throw new IllegalArgumentException("Vertex number is not valid");
        }
        
        /**
         * The return value is a list of integers.
         * Sets up a list of integers (array list).
         * Holds all adjacency vertices, we found from using the adjacency matrix. 
         */
        List<Integer> adjacentVerticesList = new ArrayList<>();
        
        /** 
         * Find the row associated with the vertex, and iterate through all the columns in that row,
         *   if 1 is present then the vertex v is directly connected to this  other vertex. 
         * 
         */
         
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[v][i] == 1) {
                adjacentVerticesList.add(i); /* Add that vertex into the list. */
            }
        }

        /* Always return the vertices in ascending order. */
        Collections.sort(adjacentVerticesList);

        return adjacentVerticesList;
    }

    
    
    
    
    
    
    
    
    
    
    
    @Override
    public GraphType TypeofGraph() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addEdge(int v1, int v2, int weight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getWeightedEdge(int v1, int v2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumVertices() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIndegree(int v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

