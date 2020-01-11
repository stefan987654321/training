package sorting

import spock.lang.Specification

class BubbleSortTest extends Specification {

    def "Should return doubles ordered from the smallest to the largest"() {

        given:
        SomeDataProvider dataProvider = Mock()
        dataProvider.provideData(amount) >> data
        BubbleSort bubbleSort = new BubbleSort(dataProvider, amount)

        when:
        def givenResult = bubbleSort.sort()

        then:
        givenResult == expectedResult

        where:
        amount | data                                   | expectedResult
        5      | [0.6, 0.2, 0.1, 0.23, 0.9]             | [0.1, 0.2, 0.23, 0.6, 0.9]
        7      | [0.1, 0.8, 0.2, 0.234, 0.5, 0.77, 0.6] | [0.1, 0.2, 0.234, 0.5, 0.6, 0.77, 0.8]
        2      | [0.1, 0.2]                             | [0.1, 0.2]
        1      | [0.7]                                  | [0.7]


    }

}
