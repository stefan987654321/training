import graphTraversing.Graph1;
import graphTraversing.Graph2;
import graphTraversing.Graph3;
import graphTraversing.GraphTraverser;
import timeApi.TimeProvider;
import treeTraversing.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        TreeTraverser treeTraverser = new TreeTraverser();
        try {
            treeTraverser.print(new Tree1());
            treeTraverser.print(new Tree2());
            treeTraverser.print(new Tree3());
        } catch (TreeException e) {
            System.out.println("Verify tree definitions!");
        }


        TimeProvider timeProvider = new TimeProvider();
        try {
            System.out.println("Current time: " + timeProvider.getCurrentTime());
        } catch (IOException e) {
            System.out.println("Cannot provide current time!");
        }

        GraphTraverser graphTraverser = new GraphTraverser();

        graphTraverser.print(new Graph1());
        graphTraverser.print(new Graph2());
        graphTraverser.print(new Graph3());
    }
}
