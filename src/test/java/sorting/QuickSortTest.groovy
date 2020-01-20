package sorting

import sorting.dataproviders.DataProvider
import spock.lang.Specification

class QuickSortTest extends Specification {

    def "Should return doubles ordered from the smallest to the largest"() {

        given:
        DataProvider dataProvider = Mock()
        dataProvider.provideData() >> data
        Sort quickSort = new QuickSort(dataProvider)

        when:
        def givenResult = quickSort.sort()

        then:
        givenResult == expectedResult

        where:
        data                                          | expectedResult
        [0.3, 0.2, 0.1, 0.0]                          | [0.0, 0.1, 0.2, 0.3]
        [2.0, 1.0, 0.0, 1.0, 2.0]                     | [0.0, 1.0, 1.0, 2.0, 2.0]
        [0.6, 0.2, 0.1, 0.23, 0.9]                    | [0.1, 0.2, 0.23, 0.6, 0.9]
        [0.1, 0.8, 0.2, 0.234, 0.5, 0.77, 0.6]        | [0.1, 0.2, 0.234, 0.5, 0.6, 0.77, 0.8]
        [0.1, 0.2]                                    | [0.1, 0.2]
        [0.7]                                         | [0.7]
        [9.0, 1.0, 2.0, 4.0, 5.0, 7.0, 8.0, 6.0, 3.0] | [1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0]


    }
}
