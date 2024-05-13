package common.http.service.services;

import common.http.service.models.Heroes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class HeroesServiceTest {
    private HeroesService heroesService;

    @BeforeEach
    void setup() {
        heroesService = new HeroesService(Heroes.summonEarlyHeroes());
    }

    @Test
    void FetchAll_GivenEmptyTodoList_ReturnListTodo() {
        List<Heroes> heroes = heroesService.fetchAll();

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

        List<Heroes> expectedResult = List.of(lion, medusa);
        Assertions.assertEquals(expectedResult, heroes);
    }

    @Test
    void FetchOneByIndex_GivenTodoListWithOneTodoObj_ReturnsTodoObj() {
        Heroes lion = Heroes.builder()
                .withId(1)
                .withName("lion")
                .withFaction("dire")
                .withAttackType("ranged")
                .withPrimaryAttribute("int")
                .build();

        Optional<Heroes> actualResult = heroesService.fetchOneByIndex(1);

        Assertions.assertEquals(lion, actualResult.get());
    }
}
