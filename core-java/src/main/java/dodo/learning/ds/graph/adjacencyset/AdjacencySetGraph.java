package dodo.learning.ds.graph.adjacencyset;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import dodo.learning.ds.graph.Graph;


public class AdjacencySetGraph implements Graph {
    
    private List<Node> vertexList = new ArrayList<>();
    private GraphType graphType = GraphType.DIRECTED;
    private int numVertices = 0;

    public AdjacencySetGraph(int numVertices, GraphType graphType) {
        this.numVertices = numVertices;
        for(int i=0; i<numVertices; i++ ) {
            vertexList.add(new Node(i));
        }
        this.graphType = graphType;
    }
    
    @Override
    public void addEdge(int v1, int v2) {
        if(v1 > numVertices || v1 > 0 || v2 > numVertices || v2 < 0) {
            throw new IllegalArgumentException("Vertex number is not valid "+v1 +","+v2);
        }
        vertexList.get(v1).addEdge(v2);
        if(graphType == GraphType.UNDIRECTED) {
            vertexList.get(v2).addEdge(v1);
        }
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if(v >= numVertices || v < 0) {
            throw new IllegalArgumentException("Vertex is not valid "+v);
        }
        return vertexList.get(v).getAdjacentVertices();
    }
    
    
    /**
     * This is depth-first traversal of a graph
     * We need to keep visited nodes so that it does not go in infinite loop
     * @param graph
     * @param visited
     * @param currentVertex
     */
    public void depthFirstTraversal(Graph graph, int[] visited, int currentVertex) {
        // base case to come out of recursion
        if(visited[currentVertex] == 1) {
            return;
        }
        visited[currentVertex] = 1;
        List<Integer> adjacentVertices = graph.getAdjacentVertices(currentVertex);
        for(int vertex : adjacentVertices) {
            depthFirstTraversal(graph, visited, vertex);
        }
        
    }

    
}
