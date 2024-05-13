package common.http.service.services;

import common.http.service.models.Heroes;

import java.util.List;
import java.util.Optional;

public class HeroesService {
    private final List<Heroes> heroes;

    public HeroesService(List<Heroes> heroes) {
        this.heroes = heroes;
    }

    public List<Heroes> fetchAll() {
        return heroes;
    }

    public Optional<Heroes> fetchOneByIndex(int index) {
        try {
            return Optional.ofNullable(heroes.get(index));
        } catch (IndexOutOfBoundsException exception) {
            return Optional.empty();
        }
    }
}
