package sorting.performance;

import sorting.SortType;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SortingReportGenerator {

    public static final String AMOUNT_HEADER = "Amount";
    public static final String TAB = "\t";
    private final double[] data;
    private final String path;
    private final int amount;

    public SortingReportGenerator(String path, double[] data) {
        this.amount = data.length;
        this.path = path;
        this.data = data;
    }

    public void generate() throws SortingReportException {
        Map<String, Map<Integer, Long>> results = new LinkedHashMap<>();

        results.put(SortType.BUBBLE.toString(), getResults(SortType.BUBBLE));
        results.put(SortType.HEAP.toString(), getResults(SortType.HEAP));
        results.put(SortType.QUICK.toString(), getResults(SortType.QUICK));

        createCsv(prepareData(results));
    }

    private Map<String, List<String>> prepareData(Map<String, Map<Integer, Long>> results) {
        Map<String, List<String>> data = new LinkedHashMap<>();

        List<String> headers = createHeaders(results);
        data.put(AMOUNT_HEADER, headers);
        for (int i = 0; i < amount; i++) {
            String key = String.valueOf(i);
            data.putIfAbsent(key, new ArrayList<>());
            for (String h : headers) {
                data.get(key).add(String.valueOf(results.get(h).get(i)));
            }
        }
        return data;
    }

    private List<String> createHeaders(Map<String, Map<Integer, Long>> results) {
        List<String> keyList = new ArrayList<>();
        for (Map.Entry<String, Map<Integer, Long>> entry : results.entrySet()) {
            keyList.add(entry.getKey());
        }
        return keyList;
    }

    private String parseList(List<String> results) {
        String list = "";
        for (String e : results) {
            list += e + TAB;
        }
        return list;
    }


    private void createCsv(Map<String, List<String>> results) throws SortingReportException {
        File file = new File(path);

        if (file.exists() == true) {

            file.setExecutable(true);
            file.setReadable(true);
            file.setWritable(true);
        }
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path))) {

            for (String k : results.keySet()) {
                writer.write(k + TAB + parseList(results.get(k)) + "\n");
            }

        } catch (IOException e) {
            throw new SortingReportException(e);
        }


    }

    private Map<Integer, Long> getResults(SortType sortType) {
        PerformanceTester performanceTester = new PerformanceTester(sortType, data);
        return performanceTester.getSortResults();
    }


}
