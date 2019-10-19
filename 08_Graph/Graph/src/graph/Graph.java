/**
 * Interface: A class with methods that have no implementations.
 *            You implement the Interface with the keyword “Implement” in a class.
 *            The key with the interface is that when you implement the interface, you must    
 *            include all functions inside the class that implements the interface.
 * 
 */
package graph;

import java.util.List;

public interface Graph {

    enum GraphType {
        DIRECTED,
        UNDIRECTED
    }

    GraphType TypeofGraph();
    void addEdge(int v1, int v2); /* unweighted*/

    void addEdge(int v1, int v2, int weight); /* weighted */

    int getWeightedEdge(int v1, int v2);

    List<Integer> getAdjacentVertices(int v); /* Data Structure */

    int getNumVertices();
 
    int getIndegree(int v);
}

