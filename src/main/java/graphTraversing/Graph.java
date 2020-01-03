package graphTraversing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {

    private Map<T, List<T>> adjacentVertices = new HashMap<>();

    public void addVertex(T vertex) {
        adjacentVertices.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(T vertex1, T vertex2) {
        adjacentVertices.get(vertex1).add(vertex2);
        adjacentVertices.get(vertex2).add(vertex1);
    }

    public List<T> getAdjacentVertices(T vertex) {
        return adjacentVertices.get(vertex);
    }
}
