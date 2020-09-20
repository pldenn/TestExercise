import com.google.gson.Gson;
import domain.JsonEntity;
import manager.Manager;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ManagerTest {
    private String method = "GET";
    private String headerName = "Cookie";
    private String headerValue = "sails.sid=s%3Art4wV8oSdI8deR8c-dNhh0p1qcOMWRuP.Ivcch%2F0QY47pb2m6I54Zg44zO09UBXLZ2MouCINTG7A";
    private String url = "https://postman-echo.com/oauth1?oauth_consumer_key=RKCGzna7bv9YD57c&oauth_signature_method=HMAC-SHA1&oauth_timestamp=1472121261&oauth_nonce=csulmT3uGwq&oauth_version=1.0&oauth_signature=PkbAfVQodqHCa4PlURX94qChwMY=";
    private Manager manager = new Manager(url, method, headerName, headerValue);

    @Test
    public void shouldCheckBody() {
        ResponseBody response = null;

        try {
            response = manager.getClient().newCall(manager.getRequest()).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        JsonEntity actual = null;
        try {
            assert response != null;
            actual = gson.fromJson(response.string(), JsonEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assertions.assertNotNull(actual);

        JsonEntity expected = new JsonEntity("pass", "OAuth-1.0a signature verification was successful");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckCode() {
        int actualCode = 0;

        try {
            actualCode = manager.getClient().newCall(manager.getRequest()).execute().code();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int expected = 200;
        Assertions.assertEquals(expected, actualCode);
    }
}
