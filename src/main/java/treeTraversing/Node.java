package treeTraversing;

public class Node<E> {

    private Node right;
    private Node left;
    private Node parent;
    private E value;

    public Node(E value) {
        this.value = value;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public E getValue() {
        return value;
    }
}
