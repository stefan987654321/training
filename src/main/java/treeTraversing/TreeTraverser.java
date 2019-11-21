package treeTraversing;

import java.util.ArrayList;
import java.util.List;

public class TreeTraverser {

    public void print(Tree tree) throws TreeException {

        System.out.println("Preorder:");
        List<Node> preorder = new ArrayList();
        Node rootNode = getRootNode(tree);
        preOrder(preorder, rootNode);
        printNodes(preorder);

        System.out.println("Inorder:");
        List<Node> inorder = new ArrayList();
        inOrder(inorder, rootNode);
        printNodes(inorder);

        System.out.println("Postorder:");
        List<Node> postorder = new ArrayList();
        postOrder(postorder, rootNode);
        printNodes(postorder);
    }


    private void printNodes(List<Node> preorder) {
        System.out.println("************");
        preorder.stream().forEach(node -> System.out.println(node.getValue().toString()));
    }

    //PLR
    public void preOrder(List<Node> order, Node node) {

        if (!order.contains(node)) {
            order.add(node);
        }

        if (node.getLeft() != null && !order.contains(node.getLeft())) {
            preOrder(order, node.getLeft());
        }

        if (node.getRight() != null && !order.contains(node.getRight())) {
            preOrder(order, node.getRight());
        }

    }

    //LPR
    public void inOrder(List<Node> order, Node node) {

        if (node.getLeft() != null && !order.contains(node)) {
            inOrder(order, node.getLeft());
        }

        if (!order.contains(node)) {
            order.add(node);
        }

        if (node.getRight() != null && !order.contains(node.getRight())) {
            inOrder(order, node.getRight());
        }
    }

    //LRP
    public void postOrder(List<Node> order, Node node) {
        if (node.getLeft() != null && !order.contains(node)) {
            postOrder(order, node.getLeft());
        }

        if (node.getRight() != null && !order.contains(node.getRight())) {
            postOrder(order, node.getRight());
        }

        if (!order.contains(node)) {
            order.add(node);
        }

    }

    private Node getRootNode(Tree tree) throws TreeException {
        Node rootNode = tree.getTree().get(0);
        if (rootNode.getParent() == null) {
            return rootNode;
        } else {
            throw new TreeException("Wrong root node!");
        }
    }
}
