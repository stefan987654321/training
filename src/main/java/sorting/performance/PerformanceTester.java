package sorting.performance;

import sorting.Sort;
import sorting.SortFactory;
import sorting.SortType;
import sorting.dataproviders.HardcodedDataProvider;

import java.util.LinkedHashMap;
import java.util.Map;

public class PerformanceTester {

    private final double[] data;
    private SortType sortType;

    public PerformanceTester(SortType sortType, double[] data) {
        this.data = data;
        this.sortType = sortType;
    }

    public Map<Integer, Long> getSortResults() {
        Map<Integer, Long> results = new LinkedHashMap<>();
        for (int i = 0; i < data.length; i++) {
            double[] smallData = prepareData(i);
            results.put(i, runTest(SortFactory.getSort(sortType, new HardcodedDataProvider(smallData))));
        }
        return results;
    }

    private double[] prepareData(int end) {
        double[] temp = new double[end + 1];
        for (int i = 0; i < end + 1; i++) {
            temp[i] = data[i];
        }
        return temp;
    }

    private long runTest(Sort sort) {
        PerformanceVerifier performanceVerifier = new PerformanceVerifier();
        return performanceVerifier.runSingleTest(sort);
    }
}
