package treeTraversing;

import java.util.Arrays;
import java.util.List;

public class Tree3 implements Tree {

    @Override
    public List<Node> getTree() {
        Node node1 = new Node(1);

        Node node2 = new Node(2);

        Node node3 = new Node(3);

        Node node4 = new Node(4);

        Node node5 = new Node(5);

        node1.setLeft(node2);
        node1.setRight(node3);

        node2.setParent(node1);
        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setParent(node1);

        node4.setParent(node2);

        node5.setParent(node2);


        return Arrays.asList(node1, node2, node3, node4, node5);
    }
}