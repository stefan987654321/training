package graphTraversing;

public class Graph3 implements GraphTemplate {

    private final static String A = "a";
    private final static String B = "b";
    private final static String C = "c";
    private final static String D = "d";
    private final static String E = "e";

    @Override
    public Graph getGraph() {
        Graph graph = new Graph();

        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);
        graph.addVertex(E);

        graph.addEdge(E, A);
        graph.addEdge(A, D);
        graph.addEdge(D, B);
        graph.addEdge(B, C);
        graph.addEdge(A, B);
        return graph;
    }

    @Override
    public String getRoot() {
        return D;
    }
}
