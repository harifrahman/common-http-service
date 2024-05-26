package common.http.service.principles.singleResponsibility;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with", toBuilder = true)
public class Transportation {
    String name;
    Integer year;
    Integer wheel;
    Integer speed;
//    Driver driverInfo;

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

    // bad example due to Transportation class must handle driver info
    public Transportation withDriverName(Transportation transportation, String driverName) {
        return transportation.toBuilder()
                .withName(transportation.getName() + "drive by: " + driverName)
                .build();
    }
}
