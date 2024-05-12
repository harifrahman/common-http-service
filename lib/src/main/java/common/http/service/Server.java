package common.http.service;

import static spark.Spark.*;

public class Server {
    public static void main(String[] args) {
        port(8080);
        initExceptionHandler((e) -> System.out.println("Something wruung.." + e.getMessage()));
        get("/ping", (req, res) -> "pong");

        path("/heroes", () -> {
            get("", (req, res) -> {
                return "{\n" +
                        "  \"success\": true,\n" +
                        "  \"data\": [\n" +
                        "    {\n" +
                        "      \"id\": 1,\n" +
                        "      \"name\": \"lion\",\n" +
                        "      \"faction\": \"dire\",\n" +
                        "      \"attackType\": \"ranged\",\n" +
                        "      \"primaryAttribute\": \"int\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\": 2,\n" +
                        "      \"name\": \"lion\",\n" +
                        "      \"faction\": \"dire\",\n" +
                        "      \"attackType\": \"ranged\",\n" +
                        "      \"primaryAttribute\": \"int\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}";
            });

            get("/:id", (req, res) -> {
                return """
                        {
                          "success": true,
                          "data": [
                            {
                              "id": 1,
                              "name": "lion",
                              "faction": "dire",
                              "attackType": "ranged",
                              "primaryAttribute": "int"
                            }
                          ]
                        }""";
            });

            post("", (req, res) -> {
                return "this is post heroes to add new heroes";
            });

            delete("/:id",  (req, res) -> {
                return "this is post heroes to add new heroes";
            });
        });
    }
}
