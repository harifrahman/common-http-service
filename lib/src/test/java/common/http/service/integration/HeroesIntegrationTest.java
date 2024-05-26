package common.http.service.integration;

import common.http.service.Server;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spark.Spark;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroesIntegrationTest {
    @BeforeAll
    static void beginServing() {
        Server.main(null);
    }

    @AfterAll
    static void stopServing() {
        Spark.stop();
    }

    @Test
    public void testGetHeroesEndpoint() throws Exception {
        String expectedResponseBody = "[{\"id\":1,\"name\":\"lion\",\"faction\":\"dire\",\"attackType\":\"ranged\",\"primaryAttribute\":\"int\"},{\"id\":2,\"name\":\"medusa\",\"faction\":\"dire\",\"attackType\":\"ranged\",\"primaryAttribute\":\"agi\"}]";

        Response response = executeRequestCall("http://localhost:8080/heroes");

        assertEquals(200, response.code());
        assertEquals(expectedResponseBody, response.body().string());
    }

    @Test
    public void testGetHeroesByIdEndpoint() throws Exception {
        String expectedResponseBody = "{\"id\":1,\"name\":\"lion\",\"faction\":\"dire\",\"attackType\":\"ranged\",\"primaryAttribute\":\"int\"}";

        Response response = executeRequestCall("http://localhost:8080/heroes/1");

        assertEquals(200, response.code());
        assertEquals(expectedResponseBody, response.body().string());
    }

    private Response executeRequestCall(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        return client.newCall(request).execute();
    }
}
