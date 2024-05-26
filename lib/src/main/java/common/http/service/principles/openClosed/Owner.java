package common.http.service.principles.openClosed;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with", toBuilder = true)
public class Owner {
    String name;
    String address;
}
