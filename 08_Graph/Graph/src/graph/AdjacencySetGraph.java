
/**
 *                                      COMPLEXITY
 *                                   =================
 * Adjacency Matrix: 
 *      Space:                          O(V^2)
 *      Is Edge present.                O(1)
 *      Iterate Over Edges On a vertex: O(V)
 * 
 * Adjacency List:  
 *      Space:                          O(E + V)
 *      Is Edge present.                O(Degree of V) : # of edges that V connects with. 
 *      Iterate Over Edges On a vertex: O(Degree of V)
 * 
 * Adjacent Set: 
 *      Space:                          O(E + V)
 *      Is Edge present.                O(Log(Degree of V)) : The # of edges on V 
 *      Iterate Over Edges On a vertex: O(Degree of V)
 */


package graph;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/* Implementing the graph interface. */
public class AdjacencySetGraph implements Graph {

    private List<Node> vertexList = new ArrayList<>(); /* Set up the list of vertex nodes. Recall, each node holds a set of adjacent verties. */
    private GraphType graphType = GraphType.DIRECTED;  /* Can be directed or undirected graph */
    private int numVertices = 0;

    
    /* Initialize the vertex list and other info in the constructor. */
    public AdjacencySetGraph(int numVertices, GraphType graphType) {
        this.numVertices = numVertices;
        for (int i = 0; i < numVertices; i++) {
            vertexList.add(new Node(i));
        }
        this.graphType = graphType;
    }

    /**
     * Specify vertices the edges connect.
     * V1: source vertex
     * V2: Destination vertex. 
     */
    @Override
    public void addEdge(int v1, int v2) {
        
        /* Base case: check if the vertices passed in are valid. */
        if (v1 >= numVertices || v1 < 0 || v2 >= numVertices || v2 < 0) {
            throw new IllegalArgumentException("Vertex number is not valid: " + v1 + ", " + v2);
        }
        /* Get the set V1, and add the edge node V2. */
        vertexList.get(v1).addEdge(v2);
        
        /* If the graph is indirected then the connection goes both ways. */
        if (graphType == GraphType.UNDIRECTED) {
            vertexList.get(v2).addEdge(v1); /* Set V1 to the set of Node V2*/
        }
    }
    


    
    /* Takes in a vertex number V*/
    @Override
    public List<Integer> getAdjacentVertices(int v) {
        
        /* Base case: make sure the node is valid. */
        if (v >= numVertices || v < 0) {
            throw new IllegalArgumentException("Vertex number is not valid: " + v);
        }
        
        /* Calls getAdjacentVertices on the Node V, and returns that value. */
        return vertexList.get(v).getAdjacentVertices();
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
    
    
    
    
    
    
    
    /* Node representing the vertex.
     * Contains an adjacency set. */
    public static class Node {

        private int vertexNumber;
        private Set<Integer> adjacencySet = new HashSet<>(); /* Each node holds a set of adjacent vertices. */

        /* Constructor: Each vertex contains an index number. */
        public Node(int vertexNumber) { this.vertexNumber = vertexNumber; }
            
        /* */
        public int getVertexNumber() { return vertexNumber; }
            
        /* Helper method: Adds an edge with this source as the node.  */
        public void addEdge(int vertexNumber) { adjacencySet.add(vertexNumber); }
            
        /* Get the adjacent verticy for this node. */
        public List<Integer> getAdjacentVertices() {
            List<Integer> sortedList = new ArrayList<>(adjacencySet);

            Collections.sort(sortedList);

            return sortedList;
        }
    }
}

