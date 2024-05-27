package common.http.service.principles.liskovSubstitution;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with", toBuilder = true)
public class PrivateTransportation implements Transportation {
    String name;
    Integer year;
    Integer wheel;
    Integer speed;
    Owner ownerInfo;

    @Override
    public String updateName(String newName) {
        return name = newName;
    }

    @Override
    public int accelerate(int acceleration) {
        return speed + acceleration;
    }
}
