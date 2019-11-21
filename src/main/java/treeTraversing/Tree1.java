package treeTraversing;

import java.util.Arrays;
import java.util.List;

public class Tree1 implements Tree{

    @Override
    public  List<Node>  getTree() {
        Node node1 = new Node(1);

        Node node5 = new Node(5);

        Node node7 = new Node(7);

        Node node12 = new Node(12);

        Node node3 = new Node(3);

        node1.setLeft(node5);
        node1.setRight(node7);

        node5.setParent(node1);

        node7.setParent(node1);
        node7.setLeft(node12);
        node7.setRight(node3);

        node12.setParent(node7);

        node3.setParent(node7);

        return Arrays.asList(node1, node5, node7, node12, node3);
    }
}
