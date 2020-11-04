package dodo.learning.ds.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyMatrixGraph implements Graph {

    private int[][] adjacencyMatrix;
    private int numVertices = 0;
    private GraphType graphType = GraphType.DIRECTED;

    AdjacencyMatrixGraph(int numOfVertices, GraphType graphType) {
        this.numVertices = numOfVertices;
        this.graphType = graphType;
        // lets initialize the matrix with all zeros
        for (int i = 0; i < numOfVertices; i++) {
            for (int j = 0; j < numOfVertices; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    @Override
    public void addEdge(int v1, int v2) {

        if (v1 >= numVertices || v1 < 0 || v2 >= numVertices || v2 < 0) {
            throw new IllegalArgumentException("Vertex number is not valid");
        }

        // i represents row and j represent column
        if (graphType == GraphType.UNDIRECTED) {
            adjacencyMatrix[v2][v1] = 1;
        } else {
            adjacencyMatrix[v1][v2] = 1;
        }
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        List<Integer> adjacentVertices = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[v][i] == 1) {
                adjacentVertices.add(i);
            }
        }
        Collections.sort(adjacentVertices);
        return adjacentVertices;
    }

}
