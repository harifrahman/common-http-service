package common.http.service.principles.liskovSubstitution;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with", toBuilder = true)
public class PublicTransportation implements Transportation {
    String name;
    Integer year;
    Integer wheel;
    Integer speed;
    String routeCode;


    @Override
    public String updateName(String newName) {
        return name = "PUB_".concat(newName);
    }

    @Override
    public int accelerate(int acceleration) {
        return speed + acceleration - 10;
    }
}
