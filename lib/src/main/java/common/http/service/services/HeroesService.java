package common.http.service.services;

import common.http.service.models.Heroes;

import java.util.List;

public class HeroesService {
    private final List<Heroes> heroes;

    public HeroesService(List<Heroes> heroes) {
        this.heroes = heroes;
    }

    public List<Heroes> fetchAll() {
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

    public List<Heroes> fetchOneByIndex(int index) {
        Heroes lion = Heroes.builder()
                .withId(index)
                .withName("lion")
                .withFaction("dire")
                .withAttackType("ranged")
                .withPrimaryAttribute("int")
                .build();

        return List.of(lion);
    }
}
