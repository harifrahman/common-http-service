package common.http.service;

import static spark.Spark.*;

public class Server {
    public static void main(String[] args) {
        port(8080);
        initExceptionHandler((e) -> System.out.println("Something wruung.." + e.getMessage()));
        get("/ping", (req, res) -> "pong");

        get("/heroes", (req, res) -> {
            return "{\"lion\": []}";
        });
    }
}
