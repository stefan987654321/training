package sorting;

import java.util.Random;

public class DataProvider implements SomeDataProvider{

    @Override
    public double[] provideData(int amount) {
        double[] data = new double[amount];
        Random random = new Random();

        for (int i = 0; i < amount; i++) {
            data[i] = random.nextDouble();
        }
        return data;
    }
}
