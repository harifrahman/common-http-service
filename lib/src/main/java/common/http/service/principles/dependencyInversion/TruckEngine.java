package common.http.service.principles.dependencyInversion;

public class TruckEngine implements Engine {
    @Override
    public String tuningEngine() {
        return "engine in best performance";
    }

    @Override
    public String fixEngine() {
        return "engine fixed";
    }

    @Override
    public boolean isBigEngine() {
        return true;
    }

    @Override
    public int getMaxSpeedEngine() {
        return 70;
    }
}
