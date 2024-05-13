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
        Heroes lion = Heroes.builder()
                .withId(1)
                .withName("lion")
                .withFaction("dire")
                .withAttackType("ranged")
                .withPrimaryAttribute("int")
                .build();

        Heroes medusa = Heroes.builder()
                .withId(2)
                .withName("medusa")
                .withFaction("dire")
                .withAttackType("ranged")
                .withPrimaryAttribute("agi")
                .build();

        HeroesController heroesController = new HeroesController(new HeroesService(List.of(lion, medusa)));
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
