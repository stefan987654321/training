package timeApi

import okhttp3.HttpUrl
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import spock.lang.Specification

class WorldClockApiTimeClientTest extends Specification {

    def "Should provide current time from server"() {
        given:
        MockWebServer mockServer = new MockWebServer()
        mockServer.start()

        MockResponse mockedResponse = new MockResponse()
        mockedResponse.setResponseCode(200)
        mockedResponse.setBody("{\"\$id\":\"1\"," +
                "\"currentDateTime\":\"2019-11-20T23:46Z\"," +
                "\"utcOffset\":\"00:00:00\",\"isDayLightSavingsTime\":false," +
                "\"dayOfTheWeek\":\"Wednesday\",\"timeZoneName\":\"UTC\"," +
                "\"currentFileTime\":132187671628581105,\"ordinalDate\":" +
                "\"2019-324\",\"serviceResponse\":null}")
        mockServer.enqueue(mockedResponse)
        HttpUrl url = mockServer.url("htt234")
        WorldClockApiTimeClient worldClockApiTimeClient = new WorldClockApiTimeClient(url.toString())

        when:
        def time = worldClockApiTimeClient.getTime()

        then:
        time.currentDateTime == "2019-11-20T23:46Z"

    }


    def "Should throw IOexception when cannot get time from the server"() {
        given:
        MockWebServer mockServer = new MockWebServer()
        mockServer.start()

        MockResponse mockedResponse = new MockResponse()
        mockedResponse.setResponseCode(500)
        mockedResponse.setBody("{\"\$id\":\"1\"," +
                "\"currentDateTime\":\"2019-11-20T23:46Z\"," +
                "\"utcOffset\":\"00:00:00\",\"isDayLightSavingsTime\":false," +
                "\"dayOfTheWeek\":\"Wednesday\",\"timeZoneName\":\"UTC\"," +
                "\"currentFileTime\":132187671628581105,\"ordinalDate\":" +
                "\"2019-324\",\"serviceResponse\":null}")
        mockServer.enqueue(mockedResponse)
        HttpUrl url = mockServer.url("htt1234")
        WorldClockApiTimeClient worldClockApiTimeClient = new WorldClockApiTimeClient(url.toString())

        when:
        worldClockApiTimeClient.getTime()

        then:
        thrown IOException

    }


}
