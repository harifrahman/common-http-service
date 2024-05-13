package common.http.service.controllers;

import common.http.service.models.Heroes;
import common.http.service.services.HeroesService;
import org.eclipse.jetty.http.HttpStatus;
import spark.Request;
import spark.Response;

import java.util.List;
import java.util.Optional;

public class HeroesController {
    HeroesService heroesService;

    public HeroesController(HeroesService heroesService) {
        this.heroesService = heroesService;
    }

    public List<Heroes> get(Request request, Response response) {
        response.status(HttpStatus.OK_200);

        return heroesService.fetchAll();
    }

    public Heroes getByIndex(Request request, Response response) {
        int index = Integer.parseInt(request.params(":id"));
        Optional<Heroes> hero = heroesService.fetchOneByIndex(index);
        if (hero.isEmpty()) {
            response.status(HttpStatus.NOT_FOUND_404);
            return Heroes.notFound();
        }

        response.status(HttpStatus.OK_200);

        return hero.get();
    }
}
