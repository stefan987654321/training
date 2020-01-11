package sorting

import sorting.dataproviders.DataProvider
import spock.lang.Specification

class HeapSortTest extends Specification {

    def "Should return doubles ordered from the smallest to the largest"() {

        given:
        DataProvider dataProvider = Mock()
        dataProvider.provideData() >> data
        Sort heapSort = new HeapSort(dataProvider)

        when:
        def givenResult = heapSort.sort()

        then:
        givenResult == expectedResult

        where:
        data                                   | expectedResult
        [0.6, 0.2, 0.1, 0.23, 0.9]             | [0.1, 0.2, 0.23, 0.6, 0.9]
        [0.1, 0.8, 0.2, 0.234, 0.5, 0.77, 0.6] | [0.1, 0.2, 0.234, 0.5, 0.6, 0.77, 0.8]
        [0.1, 0.2]                             | [0.1, 0.2]
        [0.7]                                  | [0.7]


    }
}
