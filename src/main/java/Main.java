import graphTraversing.Graph1;
import graphTraversing.Graph2;
import graphTraversing.Graph3;
import graphTraversing.GraphTraverser;
import sorting.SortType;
import sorting.dataproviders.DataUtil;
import sorting.performance.PerformanceTester;
import sorting.performance.SortingReportException;
import sorting.performance.SortingReportGenerator;
import timeApi.TimeProvider;
import treeTraversing.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {


//        runTreeTraverser();
//        runTimeProvider();
//        runGraphTraverser();
//        runSortingPerformanceTester();
        generateSortingReport();
    }

    private static void generateSortingReport() {
        SortingReportGenerator sortingReportGenerator = new SortingReportGenerator(10000);
        try {
            sortingReportGenerator.generate();
        } catch (SortingReportException e) {
            e.printStackTrace();
        }
    }

    private static void runSortingPerformanceTester() {
        PerformanceTester performanceTester = new PerformanceTester(
                SortType.BUBBLE, DataUtil.getDoublesData(100));
        System.out.println(performanceTester.getSortResults().toString());
    }

    private static void runGraphTraverser() {
        GraphTraverser graphTraverser = new GraphTraverser();

        graphTraverser.print(new Graph1());
        graphTraverser.print(new Graph2());
        graphTraverser.print(new Graph3());
    }

    private static void runTimeProvider() {
        TimeProvider timeProvider = new TimeProvider();
        try {
            System.out.println("Current time: " + timeProvider.getCurrentTime());
        } catch (IOException e) {
            System.out.println("Cannot provide current time!");
        }
    }

    private static void runTreeTraverser() {
        TreeTraverser treeTraverser = new TreeTraverser();
        try {
            treeTraverser.print(new Tree1());
            treeTraverser.print(new Tree2());
            treeTraverser.print(new Tree3());
        } catch (TreeException e) {
            System.out.println("Verify tree definitions!");
        }
    }


}
