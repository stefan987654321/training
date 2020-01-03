package graphTraversing;

public class Graph2 implements GraphTemplate {

    private final static String R = "r";
    private final static String M = "m";
    private final static String N = "n";
    private final static String O = "o";
    private final static String P = "p";
    private final static String Q = "q";

    @Override
    public Graph getGraph() {
        Graph graph = new Graph();
        graph.addVertex(R);
        graph.addVertex(M);
        graph.addVertex(N);
        graph.addVertex(P);
        graph.addVertex(O);
        graph.addVertex(P);
        graph.addVertex(Q);

        graph.addEdge(R, M);
        graph.addEdge(M, R);
        graph.addEdge(M, Q);
        graph.addEdge(M, N);
        graph.addEdge(N, O);
        graph.addEdge(N, Q);
        graph.addEdge(Q, N);
        graph.addEdge(Q, P);
        graph.addEdge(O, N);
        graph.addEdge(O, P);
        graph.addEdge(P, O);
        graph.addEdge(P, Q);
        graph.addEdge(Q, M);
        graph.addEdge(N, M);
        return graph;
    }

    @Override
    public String getRoot() {
        return R;
    }
}
