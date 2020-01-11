package sorting.dataproviders;

public class HardcodedDataProvider implements DataProvider {

    private double[] data;

    public HardcodedDataProvider(double[] data){
        this.data = data;
    }

    @Override
    public double[] provideData() {
        return data;
    }


}
