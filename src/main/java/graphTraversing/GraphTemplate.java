package graphTraversing;

public interface GraphTemplate<T> {

    Graph<T> getGraph();

    T getRoot();
}
