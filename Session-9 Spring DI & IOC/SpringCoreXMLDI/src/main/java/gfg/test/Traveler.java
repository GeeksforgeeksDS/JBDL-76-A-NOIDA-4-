package gfg.test;

public class Traveler {

    private Vehicle vehicle;

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void travel() {
        vehicle.move();
    }

}
