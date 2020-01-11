package sorting;

public class BubbleSort {
    private SomeDataProvider dataProvider;
    private final int amount;
    double data[];

    public BubbleSort(SomeDataProvider dataProvider, int amount) {
        this.dataProvider = dataProvider;
        this.amount = amount;
    }

    public double[] sort() {
        data = dataProvider.provideData(amount);

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
