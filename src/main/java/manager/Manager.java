package manager;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

import java.io.IOException;

public class Manager {

    public ResponseBody getRequest(String url, String method, String headerName, String headerValue) {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(url)
                .method(method, null)
                .addHeader(headerName, headerValue)
                .build();

        ResponseBody response = null;
        try {
            response = client.newCall(request).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
