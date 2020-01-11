package sorting.performance;

import sorting.Sort;

public class PerformanceVerifier {

    public long runSingleTest(Sort sort) {
        long startTime = System.nanoTime();
        double[] result = sort.sort();
        long stopTime = System.nanoTime();
        return isValid(result) ? (stopTime - startTime) : -1;
    }

    private boolean isValid(double[] result) {
        for (int i = result.length - 1; i >= 0; i--) {
            if (i - 1 >= 0) {
                if (result[i] < result[i - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
