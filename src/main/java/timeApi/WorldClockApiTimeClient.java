package timeApi;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WorldClockApiTimeClient implements TimeClient<Time> {

    private String url;

    public WorldClockApiTimeClient(String url) {
        this.url = url;
    }

    @Override
    public Time getTime() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Time time;
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            String responseBody = response.body().string();
            Gson gson = new Gson();
            time = gson.fromJson(responseBody, Time.class);
        }

        return time;
    }
}
