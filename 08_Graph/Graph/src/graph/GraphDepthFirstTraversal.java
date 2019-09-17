
package graph;
import java.util.List;

/**
 * Recursive type algorithm. 
 * POST ORDER TYPE.
 
 */


public class GraphDepthFirstTraversal {

    private static int N = 8;

    public static void main(String[] args) {
         
        Graph graph = new AdjacencyMatrixGraph(N, Graph.GraphType.DIRECTED);
        
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(2, 7);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(1, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 4);

        int[] visited = new int[] {0, 0, 0, 0, 0, 0, 0, 0};

        /**
         * MUST INCLUDE WHEN using a DFS of a graph.
         * This for-loop ensures that all nodes are covered even for an unconnected graph 
         * Recursively Iterate through all the nodes and start the DFS at every NODE.
         * Ensure that even unconnected nodes are covered. 
         */
        for (int i = 0; i < N; i++) {
            depthFirstTraversal(graph, visited, i);
        }
    }
    /* Specify the graph we want to traverse, the list of visited nodes. Mark as 1 if has been visited. And the current vertex we'll be visising.  */
    public static void depthFirstTraversal(Graph graph, int[] visited, int currentVertex) {
        
        /* Base case: If it has been visited, simply return. */
        if (visited[currentVertex] == 1) { return; }
           
        /* Set the current vertex as visisted, assuming it hasn't been visited till this point. */
        visited[currentVertex] = 1;

        /* Get all the adjacent vertecies of the current vertex. */
        List<Integer> list = graph.getAdjacentVertices(currentVertex);
        
        /* Iterate through the verticies, and recursively call depthFirstTraversal on all the adjacent verticies. */
        for (int vertex : list) {
            depthFirstTraversal(graph, visited, vertex);
        }
        /* Process the node. */
        System.out.print(currentVertex + "->");
    }
}