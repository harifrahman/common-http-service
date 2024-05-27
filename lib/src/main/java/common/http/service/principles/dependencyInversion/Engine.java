package common.http.service.principles.dependencyInversion;

public interface Engine {
    String tuningEngine();
    String fixEngine();
    boolean isBigEngine();
    int getMaxSpeedEngine();
}
