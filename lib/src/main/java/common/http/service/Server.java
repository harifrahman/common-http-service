package common.http.service;

import common.http.service.controllers.HeroesController;
import common.http.service.services.HeroesService;

import java.util.Collections;

import static spark.Spark.*;

public class Server {

    public static void main(String[] args) {
        HeroesController heroesController = new HeroesController(new HeroesService(Collections.emptyList()));
        port(8080);

        initExceptionHandler((e) -> System.out.println("Something wruung.." + e.getMessage()));
        get("/ping", (req, res) -> "pong");

        path("/heroes", () -> {
            get("", heroesController::get);

            get("/:id", heroesController::getByIndex);

            post("", (req, res) -> {
                return "this is post heroes to add new heroes";
            });

            delete("/:id", (req, res) -> {
                return "this is post heroes to add new heroes";
            });
        });
    }
}
