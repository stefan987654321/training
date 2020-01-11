package sorting.dataproviders;

public class RandomDataProvider implements DataProvider {

    private int amount = 10;

    @Override
    public double[] provideData() {
        return getDoublesData();
    }

    private double[] getDoublesData() {
        return DataUtil.getDoublesData(amount);
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
