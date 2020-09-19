import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://postman-echo.com/oauth1?oauth_consumer_key=RKCGzna7bv9YD57c&oauth_signature_method=HMAC-SHA1&oauth_timestamp=1472121261&oauth_nonce=csulmT3uGwq&oauth_version=1.0&oauth_signature=PkbAfVQodqHCa4PlURX94qChwMY=")
                .method("GET", null)
                .addHeader("Cookie", "sails.sid=s%3Art4wV8oSdI8deR8c-dNhh0p1qcOMWRuP.Ivcch%2F0QY47pb2m6I54Zg44zO09UBXLZ2MouCINTG7A")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response);

    }
}
