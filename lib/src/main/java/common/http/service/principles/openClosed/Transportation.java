package common.http.service.principles.openClosed;

import lombok.Builder;
import lombok.Data;

/**
 * open closed -> open for extension, close for modify.
 * less modifier in exists (run) code, means lesser to create new bug
 * Lets say, arif want to have Public transportation and private one.
 * we can simply add boolean like isPublicTransportation under this class
 * but what if we need to add other property like ownerName & ownerAdrress for privateTransportation
 * and routeCode for public one.
 *
 * That's why better to extend Transportation class and override some property / method if needed
 * */
@Data
@Builder(setterPrefix = "with", toBuilder = true)
public class Transportation {
    String name;
    Integer year;
    Integer wheel;
    Integer speed;
//    boolean isPublicTransportation;

    public String updateName(String newName) {
        return name = newName;
    }

    public int accelerate(int acceleration) {
        return speed + acceleration;
    }

    public Transportation initCarData() {
        return Transportation.builder()
                .withWheel(4)
                .withYear(2001)
                .withName("Toyota")
                .withSpeed(40)
                .build();
    }
}
