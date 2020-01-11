package sorting;

import sorting.dataproviders.DataProvider;

public class BubbleSort implements Sort {
    private int amount;
    double data[];

    public BubbleSort(DataProvider dataProvider) {
        this.data = dataProvider.provideData();
        amount = data.length;
    }

    @Override
    public double[] sort() {

        boolean isChanged = true;
        while (isChanged) {
            isChanged = false;
            for (int i = amount - 1; i >= 0; i--) {
                if (i - 1 >= 0) {
                    double x = data[i];
                    double y = data[i - 1];
                    if (x < y) {
                        data[i] = y;
                        data[i - 1] = x;
                        isChanged = true;
                    }
                }

            }
        }
        return data;
    }

}
