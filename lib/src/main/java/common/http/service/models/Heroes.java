package common.http.service.models;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class Heroes {
    Integer id;
    String name;
    String faction;
    String attackType;
    String primaryAttribute;
}
