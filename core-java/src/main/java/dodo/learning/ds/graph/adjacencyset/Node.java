package dodo.learning.ds.graph.adjacencyset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Node {
    
    private int vertexId;
    private Set<Integer> adjacencySet;
    
    public Node(int vertexId) {
        this.vertexId = vertexId;
        adjacencySet = new HashSet<>();
    }
    
    public int getVertexId() {
        return vertexId;
    }
    
    public void setVertexId(int vertexId) {
        this.vertexId = vertexId;
    }
    
    public Set<Integer> getNodes() {
        return adjacencySet;
    }
    
    public void setNodes(Set<Integer> nodes) {
        this.adjacencySet = nodes;
    }
    
    public void addEdge(int vertextNumber) {
        this.adjacencySet.add(vertextNumber);
    }
    
    public List<Integer> getAdjacentVertices(){
        List<Integer> sortedList = new ArrayList<>(adjacencySet);
        Collections.sort(sortedList);
        return sortedList;
        
    }
    
    

}
