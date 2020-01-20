package sorting.performance


import sorting.HeapSort
import sorting.Sort
import sorting.dataproviders.DataProvider
import sorting.dataproviders.HardcodedDataProvider
import spock.lang.Specification

class PerformanceVerifierTest extends Specification {

    def "Should return time needed to sort data"() {
        given:
        double[] data = [0.6, 9.8, 1.3, 4.7, 0.2, 0.2, 4.6, 8, 9.0, 3.1]
        PerformanceVerifier performanceVerifier = new PerformanceVerifier()
        DataProvider dataProvider = new HardcodedDataProvider(data)
        Sort heapSort = new HeapSort(dataProvider)

        when:
        def result = performanceVerifier.runSingleTest(heapSort)

        then:
        result != -1
        result > 0
    }
}
