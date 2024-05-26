package common.http.service.principles.openClosed;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with", toBuilder = true)
public class PublicTransportation extends Transportation {
    String routeCode;

    @Builder
    public PublicTransportation(String name, Integer year, Integer wheel, Integer speed, String routeCode) {
        super(name, year, wheel, speed);
        this.routeCode = routeCode;
    }

    @Override
    public int accelerate(int acceleration) {
        return speed + acceleration - 10;
    }
}
