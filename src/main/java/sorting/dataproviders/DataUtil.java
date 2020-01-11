package sorting.dataproviders;

import java.util.Random;

public class DataUtil {

    public static double[] getDoublesData(int amount) {
        double[] data = new double[amount];
        Random random = new Random();

        for (int i = 0; i < amount; i++) {
            data[i] = random.nextDouble();
        }
        return data;
    }
}
