package common.http.service;

import common.http.service.controllers.HeroesController;
import common.http.service.controllers.JsonTransformer;
import common.http.service.models.Heroes;
import common.http.service.services.HeroesService;

import java.util.List;

import static spark.Spark.*;

public class Server {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        HeroesController heroesController = new HeroesController(new HeroesService(Heroes.summonEarlyHeroes()));
        JsonTransformer jsonTransformer = new JsonTransformer();
        port(PORT);

        initExceptionHandler((e) -> System.out.println("Something wruung.." + e.getMessage()));
        get("/ping", (req, res) -> "pong");

        path("/heroes", () -> {
            get("", heroesController::get, jsonTransformer);

            get("/:id", heroesController::getByIndex, jsonTransformer);

            post("", (req, res) -> {
                return "this is post heroes to add new heroes";
            });

            delete("/:id", (req, res) -> {
                return "this is post heroes to add new heroes";
            });
        });
    }
}
