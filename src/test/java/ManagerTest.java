import com.google.gson.Gson;
import domain.JsonEntity;
import manager.Manager;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ManagerTest {
    private Manager manager = new Manager();

    @Test
    public void shouldCheckStatusAndMessage(){
        String method = "GET";
        String headerName = "Cookie";
        String headerValue = "sails.sid=s%3Art4wV8oSdI8deR8c-dNhh0p1qcOMWRuP.Ivcch%2F0QY47pb2m6I54Zg44zO09UBXLZ2MouCINTG7A";
        String url = "https://postman-echo.com/oauth1?oauth_consumer_key=RKCGzna7bv9YD57c&oauth_signature_method=HMAC-SHA1&oauth_timestamp=1472121261&oauth_nonce=csulmT3uGwq&oauth_version=1.0&oauth_signature=PkbAfVQodqHCa4PlURX94qChwMY=";

        ResponseBody response = manager.getRequest(url, method, headerName, headerValue);
        Gson gson = new Gson();
        JsonEntity actual = null;

        try {
            actual = gson.fromJson(response.string(), JsonEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assertions.assertNotNull(actual);

        JsonEntity expected = new JsonEntity("pass", "OAuth-1.0a signature verification was successful");
        Assertions.assertEquals(expected, actual);
    }
}
