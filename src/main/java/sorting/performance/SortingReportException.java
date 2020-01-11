package sorting.performance;

public class SortingReportException extends Exception {
    public SortingReportException(String m) {
        super(m);
    }

    public SortingReportException(Exception ex){
        super(ex);
    }
}
