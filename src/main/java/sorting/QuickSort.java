package sorting;

import sorting.dataproviders.DataProvider;

public class QuickSort implements Sort {
    private final double[] data;
    private final int amount;

    public QuickSort(DataProvider dataProvider) {
        this.data = dataProvider.provideData();
        this.amount = data.length;
    }

    @Override
    public double[] sort() {
        runQuickSort(0, amount - 1);
        return data;
    }

    private void runQuickSort(int start, int end) {
        if (start < end) {
            int limit = split(start, end);
            runQuickSort(start, limit - 1);
            runQuickSort(limit + 1, end);
        }
    }

    private int split(int start, int end) {
        int limit = start - 1;
        for (int i = start; i < end; i++) {
            if (data[i] <= data[end]) {
                limit = swapItems(limit, i);
            }
        }
        return swapItems(limit, end);
    }

    private int swapItems(int limit, int index) {
        limit = limit + 1;
        double temp = data[limit];
        data[limit] = data[index];
        data[index] = temp;
        return limit;
    }
}


