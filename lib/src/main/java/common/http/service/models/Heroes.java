package common.http.service.models;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder(setterPrefix = "with")
public class Heroes {
    Integer id;
    String name;
    String faction;
    String attackType;
    String primaryAttribute;

    public static List<Heroes> summonEarlyHeroes() {
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

        return List.of(lion, medusa);
    }

    public static Heroes notFound() {
        return Heroes.builder().build();
    }
}
