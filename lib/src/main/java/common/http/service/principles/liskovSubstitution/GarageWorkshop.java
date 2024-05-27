package common.http.service.principles.liskovSubstitution;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class GarageWorkshop {

    Transportation configureSpeed(Transportation vehicle) {
        if (vehicle instanceof PublicTransportation) {
            vehicle.accelerate(-10);
            return vehicle;
        }

        vehicle.accelerate(0);
        return vehicle;
    }
}
