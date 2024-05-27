package common.http.service.principles.liskovSubstitution;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with", toBuilder = true)
public class Owner {
    String name;
    String address;
}
