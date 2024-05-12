package common.http.service.controllers;

import common.http.service.models.Heroes;
import common.http.service.services.HeroesService;
import org.eclipse.jetty.http.HttpStatus;
import spark.Request;
import spark.Response;

import java.util.List;

public class HeroesController {
    HeroesService heroesService;

    public HeroesController(HeroesService heroesService) {
        this.heroesService = heroesService;
    }

    public List<Heroes> get(Request request, Response response) {
        response.status(HttpStatus.OK_200);

        return heroesService.fetchAll();
    }

    public List<Heroes> getByIndex(Request request, Response response) {
        response.status(HttpStatus.OK_200);
        int index = Integer.parseInt(request.params(":id"));

        return heroesService.fetchOneByIndex(index);
    }
}
