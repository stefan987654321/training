package graphTraversing;

import java.util.*;

public class GraphTraverser<T> {

    public void print(GraphTemplate<T> graphTemplate) {
        Set<T> visited1 = new LinkedHashSet<>();

        System.out.println("*******************");

        System.out.println("\nBreadth First Search: ");
        System.out.println(breadthFirstSearch(visited1, graphTemplate.getGraph(),
                 graphTemplate.getRoot()).toString());


        Set<T> visited2 = new LinkedHashSet<>();
        System.out.println("\nDepth First Search: ");
        System.out.println(depthFirstSearch(visited2, graphTemplate.getGraph(),
                 graphTemplate.getRoot()).toString());


    }

    public Set<T> breadthFirstSearch(Set<T> visited, Graph<T> graph, T root) {
        Queue<T> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            T vertex = queue.poll();
            graph.getAdjacentVertices(vertex).forEach(v -> {
                if (!visited.contains(v)) {
                    visited.add(v);
                    queue.add(v);
                }
            });

        }
        return visited;
    }

    public Set<T> depthFirstSearch(Set<T> visited, Graph<T> graph, T root) {
        Stack<T> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            T vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                graph.getAdjacentVertices(vertex).forEach(stack::push);
            }
        }
        return visited;
    }
}
