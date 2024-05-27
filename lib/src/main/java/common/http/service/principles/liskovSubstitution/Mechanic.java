package common.http.service.principles.liskovSubstitution;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Mechanic {
    GarageWorkshop garageWorkshop;

    public Transportation quickFix() {
        PublicTransportation bus = PublicTransportation.builder()
                .withSpeed(60)
                .build();
        return garageWorkshop.configureSpeed(bus); // bus.speed -> 50 | configureSpeed can accept both public / private transport (substitute-able)
    }

    public Transportation quickFix2() {
        PrivateTransportation bmw = PrivateTransportation.builder()
                .withSpeed(60)
                .build();
        return garageWorkshop.configureSpeed(bmw); // bmw.speed -> 60 | configureSpeed can accept both public / private transport (substitute-able)
    }
}
