package common.http.service.principles.dependencyInversion;

public class Garage {

    // tight coupling, means if truckEngine or Truck signature modified, this will affect Garage class also
//    Truck truck;
//    TruckEngine truckEngine;
//    public Garage() {
//        truck = new Truck();
//        truckEngine = new TruckEngine();
//    }

    Transportation vehicle;
    Engine vehicleEngine;

    public Garage(Transportation vehicle, Engine vehicleEngine) {
        this.vehicle = vehicle;
        this.vehicleEngine = vehicleEngine;
    }
}
