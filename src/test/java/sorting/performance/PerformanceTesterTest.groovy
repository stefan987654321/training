package sorting.performance


import sorting.SortType
import sorting.dataproviders.DataUtil
import spock.lang.Specification

class PerformanceTesterTest extends Specification {

    def "Should return map with results and execution length should be different than -1"() {

        given:
        PerformanceTester performanceTester = new PerformanceTester(sortType, data)
        when:
        def results = performanceTester.getSortResults()
        then:

        results.size() == data.size()
        results.entrySet().each {
            it.value != -1
        }

        where:
        sortType        | data
        SortType.BUBBLE | [0.1, 0.8, 0.2, 0.234, 0.5, 0.77, 0.6] as double[]
        SortType.HEAP   | [0.01, 0.8, 0.32, 0.234, 0.565, 0.77, 0.666, 0.9876, 0.4] as double[]

    }

    def "Should return results bigger than 1 ns when data is big"() {

        given:
        def data = DataUtil.getDoublesData(1000)
        PerformanceTester performanceTester = new PerformanceTester(SortType.BUBBLE, data)
        when:
        def results = performanceTester.getSortResults()
        then:

        results.size() == data.size()
        results.entrySet().each {
            it.value > 0
        }


    }
}
