package manager;

import lombok.Data;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@Data
public class Manager {

    private OkHttpClient client;
    private Request request;

    public Manager(String url, String method, String headerName, String headerValue) {

        client = new OkHttpClient().newBuilder()
                .build();
        request = new Request.Builder()
                .url(url)
                .method(method, null)
                .addHeader(headerName, headerValue)
                .build();
    }
}
