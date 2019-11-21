package timeApi

import spock.lang.Specification

class TimeProviderTest extends Specification {

    TimeClient timeClient

    def setup() {
        Time time = new Time("1", "2019-12-12 00:00:00",
                "+0000", true, "friday",
                "gmt", 12345, "", "")
        timeClient = Mock()
        timeClient.getTime() >> time
    }

    def "Should provide current time"() {
        given:
        TimeProvider timeProvider = new TimeProvider(timeClient)

        when:
        def result = timeProvider.currentTime

        then:
        result == "2019-12-12 00:00:00"
    }
}
