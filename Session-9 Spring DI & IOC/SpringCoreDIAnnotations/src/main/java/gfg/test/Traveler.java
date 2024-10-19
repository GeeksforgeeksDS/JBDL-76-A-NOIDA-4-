package gfg.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Traveler {

    @Autowired
    @Qualifier("car")
    private Vehicle vehicle;

//    @Autowired
//    @Qualifier("bike")
//    public void setVehicle(Vehicle vehicle) {
//        this.vehicle = vehicle;
//    }

//    @Autowired
//    public Traveler(@Qualifier("bike") Vehicle vehicle) {
//        this.vehicle = vehicle;
//    }

    public void travel() {
        vehicle.move();
    }

}
