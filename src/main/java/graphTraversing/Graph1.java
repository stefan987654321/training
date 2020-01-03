package graphTraversing;

public class Graph1 implements GraphTemplate<String>{
    private final static String BOB = "Bob";
    private final static String ALICE = "Alice";
    private final static String MARK = "Mark";
    private final static String ROB = "Rob";
    private final static String MARIA = "Maria";

    @Override
    public Graph<String> getGraph() {
        Graph<String> graph = new Graph<>();
        graph.addVertex(BOB);
        graph.addVertex(ALICE);
        graph.addVertex(MARK);
        graph.addVertex(ROB);
        graph.addVertex(MARIA);
        graph.addEdge(BOB, ALICE);
        graph.addEdge(BOB, ROB);
        graph.addEdge(ALICE, MARK);
        graph.addEdge(ROB, MARK);
        graph.addEdge(ALICE, MARIA);
        graph.addEdge(ROB, MARIA);
        return graph;
    }

    @Override
    public String getRoot() {
        return BOB;
    }
}
