package common.http.service.integration;

import common.http.service.Server;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;
import spark.Spark;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroesIntegrationTest {

    @Test
    public void testGetHeroesEndpoint() throws Exception {
        String expectedResponseBody = "[{\"id\":1,\"name\":\"lion\",\"faction\":\"dire\",\"attackType\":\"ranged\",\"primaryAttribute\":\"int\"},{\"id\":2,\"name\":\"medusa\",\"faction\":\"dire\",\"attackType\":\"ranged\",\"primaryAttribute\":\"agi\"}]";

        Spark.port(8080); // this must same with port we select to run our app
        Server.main(null);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://localhost:8080/heroes")
                .build();
        Response response = client.newCall(request).execute();

        assertEquals(200, response.code());
        assertEquals(expectedResponseBody, response.body().string());

        Spark.stop();
    }
}
