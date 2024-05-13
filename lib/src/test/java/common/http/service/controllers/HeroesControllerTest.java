package common.http.service.controllers;

import common.http.service.models.Heroes;
import common.http.service.services.HeroesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spark.Request;
import spark.Response;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

class HeroesControllerTest {

    private Request request;
    private Response response;
    private HeroesController heroesController;
    private HeroesService heroesService;

    @BeforeEach
    void initializeSetup() {
        request = mock(Request.class);
        response = mock(Response.class);
    }

    @Test
    void GivenEmptyInitialHeroesWhenFetchAllHeroesShouldReturnResponseJson() {
        heroesService = new HeroesService(Collections.emptyList());
        heroesController = new HeroesController(heroesService);

        List<Heroes> expectedResponse = Collections.emptyList();

        List<Heroes> actualResponse = heroesController.get(request, response);
        Assertions.assertEquals(expectedResponse, actualResponse);
        verify(response).status(200);
    }

    @Test
    void GivenInitialHeroesWhenFetchAllHeroesShouldReturnResponseJson() {
        heroesService = new HeroesService(Heroes.summonEarlyHeroes());
        heroesController = new HeroesController(heroesService);

        List<Heroes> expectedResponse = Heroes.summonEarlyHeroes();

        List<Heroes> actualResponse = heroesController.get(request, response);
        Assertions.assertEquals(expectedResponse, actualResponse);
        verify(response).status(200);
    }

    @Test
    void GivenHeroIdOneWhenGetByIndexShouldReturnsHeroCorrectly() {
        Heroes heroIdOne = Heroes.builder()
                .withId(1)
                .withName("lion")
                .withFaction("dire")
                .withAttackType("ranged")
                .withPrimaryAttribute("agi")
                .build();
        heroesService = new HeroesService(List.of(heroIdOne));
        heroesController = new HeroesController(heroesService);

        when(request.params(":id")).thenReturn("1");
        Heroes actualResponse = heroesController.getByIndex(request, response);

        Assertions.assertEquals(heroIdOne, actualResponse);
        verify(response).status(200);
    }

    @Test
    void GivenHeroIdOneWhenGetByWrongIndexShouldReturnsEmptyJsonWith() {
        Heroes heroIdOne = Heroes.builder()
                .withId(1)
                .withName("lion")
                .withFaction("dire")
                .withAttackType("ranged")
                .withPrimaryAttribute("agi")
                .build();
        heroesService = new HeroesService(List.of(heroIdOne));
        heroesController = new HeroesController(heroesService);

        when(request.params(":id")).thenReturn("2");
        Heroes actualResponse = heroesController.getByIndex(request, response);

        Assertions.assertEquals(Heroes.builder().build(), actualResponse);
        verify(response).status(404);
    }
}