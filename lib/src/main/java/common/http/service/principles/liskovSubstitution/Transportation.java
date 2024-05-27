package common.http.service.principles.liskovSubstitution;

public interface Transportation {
    String updateName(String newName);
    int accelerate(int acceleration);
}
