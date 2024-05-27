package common.http.service.principles.dependencyInversion;

public interface Transportation {
    String updateName(String newName);
    int accelerate(int acceleration);
}
