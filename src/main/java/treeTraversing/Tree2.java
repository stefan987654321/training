package treeTraversing;

import java.util.Arrays;
import java.util.List;

public class Tree2 implements Tree{

    @Override
    public List<Node> getTree(){
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");


        nodeA.setLeft(nodeB);
        nodeA.setRight(nodeC);

        nodeB.setParent(nodeA);
        nodeB.setLeft(nodeD);
        nodeB.setRight(nodeE);

        nodeC.setParent(nodeA);
        nodeC.setRight(nodeG);

        nodeD.setParent(nodeB);

        nodeE.setParent(nodeB);
        nodeE.setLeft(nodeF);

        nodeF.setParent(nodeE);

        nodeG.setParent(nodeC);
        nodeG.setLeft(nodeH);

        nodeH.setParent(nodeG);

        nodeG.setParent(nodeC);


        return Arrays.asList(nodeA, nodeB, nodeC, nodeD, nodeE, nodeF, nodeG, nodeH);
    }
}
