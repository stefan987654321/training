package timeApi;

import java.io.IOException;

public class TimeProvider {
    private static final String TIME_API_URL = "http://worldclockapi.com/api/json/utc/now";

    private final TimeClient<Time> timeClient;

    public TimeProvider() {
        timeClient = new WorldClockApiTimeClient(TIME_API_URL);
    }

    public TimeProvider(TimeClient<Time> timeClient) {
        this.timeClient = timeClient;
    }

    public String getCurrentTime() throws IOException {
        return timeClient.getTime().getCurrentDateTime();
    }
}

