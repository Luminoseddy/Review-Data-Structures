package graph;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/* Implementing the graph interface. */
public class AdjacencySetGraph implements Graph {

    private List<Node> vertexList = new ArrayList<>();
    private GraphType graphType = GraphType.DIRECTED;
    private int numVertices = 0;

    public AdjacencySetGraph(int numVertices, GraphType graphType) {
        this.numVertices = numVertices;
        for (int i = 0; i < numVertices; i++) {
            vertexList.add(new Node(i));
        }
        this.graphType = graphType;
    }

    @Override
    public void addEdge(int v1, int v2) {
        if (v1 >= numVertices || v1 < 0 || v2 >= numVertices || v2 < 0) {
            throw new IllegalArgumentException("Vertex number is not valid: " + v1 + ", " + v2);
        }

        vertexList.get(v1).addEdge(v2);
        if (graphType == GraphType.UNDIRECTED) {
            vertexList.get(v2).addEdge(v1);
        }
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if (v >= numVertices || v < 0) {
            throw new IllegalArgumentException("Vertex number is not valid: " + v);
        }

        return vertexList.get(v).getAdjacentVertices();
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

