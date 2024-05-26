package common.http.service.principles.singleResponsibility;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with", toBuilder = true)
public class Driver {
    String name;
    Integer age;
    String licenceNo;

    // better to move driver info to it own class (better in testing + easy to maintain + less dependency)
    public String updateName(String newName) {
        return name = newName;
    }
}
