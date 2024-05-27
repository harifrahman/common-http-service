package common.http.service.principles.dependencyInversion;

public class Truck implements Transportation {
    @Override
    public String updateName(String newName) {
        return "Baratrum truck";
    }

    @Override
    public int accelerate(int acceleration) {
        return 20;
    }
}
