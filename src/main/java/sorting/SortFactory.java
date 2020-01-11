package sorting;

import sorting.dataproviders.DataProvider;

public class SortFactory {

    public static Sort getSort(SortType sortType, DataProvider dataProvider) {
        if (sortType == SortType.BUBBLE) {
            return new BubbleSort(dataProvider);
        }

        if (sortType == SortType.HEAP) {
            return new HeapSort(dataProvider);
        }

        if (sortType == SortType.QUICK) {
            return new QuickSort(dataProvider);
        }
        return null;
    }
}
