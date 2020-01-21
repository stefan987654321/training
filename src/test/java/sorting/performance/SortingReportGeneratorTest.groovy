package sorting.performance

import sorting.SortType
import sorting.dataproviders.DataUtil
import spock.lang.Specification

class SortingReportGeneratorTest extends Specification {

    def private static final PATH = "test_file.txt"
    def private static final AMOUNT = 10
    def private file = new File(PATH)

    def cleanup() {
        file.delete()
    }

    def "Should create sorting report"() {
        given:
        double[] data = DataUtil.getDoublesData(AMOUNT)
        SortingReportGenerator sortingReportGenerator = new SortingReportGenerator(PATH, data)

        when:

        sortingReportGenerator.generate()

        then:
        file.exists()
        file.canRead()
    }

    def "Should create report with proper content"() {
        given:
        double[] data = DataUtil.getDoublesData(AMOUNT)
        SortingReportGenerator sortingReportGenerator = new SortingReportGenerator(PATH, data)

        when:
        sortingReportGenerator.generate()
        def content = readFile(file)

        then:
        content.contains(SortingReportGenerator.AMOUNT_HEADER)
        content.contains(SortType.BUBBLE.toString())
        content.contains(SortType.HEAP.toString())
        content.contains(SortType.QUICK.toString())

        for (number in 0..AMOUNT) {
            content.contains("\n" + number.toString() + "\t")
        }
    }

    private String readFile(File file) {
        def content = ""
        def line
        file.withReader { reader ->
            while ((line = reader.readLine()) != null) {
                content += line
            }
        }
        return content
    }
}
