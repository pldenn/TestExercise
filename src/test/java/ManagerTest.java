import com.google.gson.Gson;
import domain.JsonObject;
import manager.Manager;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ManagerTest {
    Manager manager = new Manager();

    @Test
    public void shouldCheckStatusAndMessage() throws IOException {
        String method = "GET";
        String headerName = "Cookie";
        String headerValue = "sails.sid=s%3Art4wV8oSdI8deR8c-dNhh0p1qcOMWRuP.Ivcch%2F0QY47pb2m6I54Zg44zO09UBXLZ2MouCINTG7A";
        String url = "https://postman-echo.com/oauth1?oauth_consumer_key=RKCGzna7bv9YD57c&oauth_signature_method=HMAC-SHA1&oauth_timestamp=1472121261&oauth_nonce=csulmT3uGwq&oauth_version=1.0&oauth_signature=PkbAfVQodqHCa4PlURX94qChwMY=";

        ResponseBody response = manager.getRequest(url, method, headerName, headerValue);
        Gson gson = new Gson();
        JsonObject actual = gson.fromJson(response.string(), JsonObject.class);

        JsonObject expected = new JsonObject("pass", "OAuth-1.0a signature verification was successful");

        Assertions.assertNotNull(expected);
        Assertions.assertEquals(expected, actual);

    }
}
