package common.http.service.principles.interfaceSegregation;

public class Mechanic implements Transportation, Engine{

    @Override
    public String tuningEngine() {
        return null;
    }

    @Override
    public String fixEngine() {
        return null;
    }

    @Override
    public boolean isBigEngine() {
        return false;
    }

    @Override
    public int getMaxSpeedEngine() {
        return 0;
    }

    @Override
    public String updateName(String newName) {
        return null;
    }

    @Override
    public int accelerate(int acceleration) {
        return 0;
    }
}
