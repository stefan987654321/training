package sorting;

import sorting.dataproviders.DataProvider;

public class HeapSort implements Sort {

    private int amount;
    double data[];

    public HeapSort(DataProvider dataProvider) {
        this.data = dataProvider.provideData();
        this.amount = data.length;
    }

    @Override
    public double[] sort() {

        int length = amount;
        for (int i = length / 2 - 1; i >= 0; i--) {
            swap(length, i, data);
        }

        for (int i = length - 1; i >= 0; i--) {
            double temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            swap(i, 0, data);
        }
        return data;
    }

    private void swap(int length, int index, double[] data) {
        int x = index;
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        if (left < length && data[left] > data[x]) {
            x = left;
        }

        if (right < length && data[right] > data[x]) {
            x = right;
        }

        if (x != index) {
            double swap = data[index];
            data[index] = data[x];
            data[x] = swap;

            swap(length, x, data);
        }
    }
}
