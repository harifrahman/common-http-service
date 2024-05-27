package common.http.service.principles.openClosed;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrivateTransportation extends Transportation {
    Owner ownerInfo;

    @Builder
    public PrivateTransportation(String name, Integer year, Integer wheel, Integer speed, Owner ownerInfo) {
        super(name, year, wheel, speed);
        this.ownerInfo = ownerInfo;
    }
}
