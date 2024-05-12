package common.http.service.controllers;

import common.http.service.models.Heroes;
import org.eclipse.jetty.http.HttpStatus;
import spark.Request;
import spark.Response;

import java.util.List;

public class HeroesController {

    public List<Heroes> get(Request request, Response response) {
        response.status(HttpStatus.OK_200);

        Heroes lion = Heroes.builder()
                .withId(1)
                .withName("lion")
                .withFaction("dire")
                .withAttackType("ranged")
                .withPrimaryAttribute("int")
                .build();

        Heroes medusa = Heroes.builder()
                .withId(1)
                .withName("medusa")
                .withFaction("dire")
                .withAttackType("ranged")
                .withPrimaryAttribute("agi")
                .build();

        return List.of(lion, medusa);
    }

    public List<Heroes> getByIndex(Request request, Response response) {
        response.status(HttpStatus.OK_200);

        Heroes lion = Heroes.builder()
                .withId(1)
                .withName("lion")
                .withFaction("dire")
                .withAttackType("ranged")
                .withPrimaryAttribute("int")
                .build();

        return List.of(lion);
    }
}
