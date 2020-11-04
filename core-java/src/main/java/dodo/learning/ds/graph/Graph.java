package dodo.learning.ds.graph;

import java.util.List;

public interface Graph {
    
    
    enum GraphType {
        DIRECTED,
        UNDIRECTED
    }
    // source and destination vertices
    void addEdge(int v1, int v2);
    
    // Get all the vertices which are connected
    List<Integer> getAdjacentVertices(int v);

}
