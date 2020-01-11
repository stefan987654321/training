package sorting.performance;

import sorting.SortType;
import sorting.dataproviders.DataUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class SortingReportGenerator {

    private static final String PATH = "report.csv";
    public static final String AMOUNT_HEADER = "Amount";
    public static final String TAB = "\t";
    private final double[] data;
    private PerformanceTester performanceTester;
    private int amount;

    public SortingReportGenerator(int amount) {
        this.amount = amount;
        data = DataUtil.getDoublesData(amount);
    }

    public void generate() throws SortingReportException {
        Map<String, Map<Integer, Long>> results = new LinkedHashMap<>();
        Map<Integer, Long> bubbleResults = getResults(SortType.BUBBLE);
        Map<Integer, Long> heapResults = getResults(SortType.HEAP);

        if (bubbleResults.size() != amount || heapResults.size() != amount) {
            throw new SortingReportException("Data corrupted!");
        }

        results.put(SortType.BUBBLE.toString(), bubbleResults);
        results.put(SortType.HEAP.toString(), heapResults);

        createCsv(prepareData(results));
    }

    private Map<String, List<String>> prepareData(Map<String, Map<Integer, Long>> results) {
        Map<String, List<String>> data = new LinkedHashMap<>();

        List<String> headers = createHeaders(results);
        data.put(AMOUNT_HEADER, headers);
        for (int i = 0; i <amount; i++) {
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
        File file = new File(PATH);

        if (file.exists() == true) {

            file.setExecutable(true);
            file.setReadable(true);
            file.setWritable(true);
        }
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(PATH))) {

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
