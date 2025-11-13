package com.srt.interfacce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Garrage {

  @Qualifier("truck")
    @Autowired
    Vehicle vehicle; // Spring will find the only bean of type Vehicle (Car) and inject it.
    
    public Garrage() {
        System.out.println("Garrage object created");
    }

    // Add a method to test the injection
    public void startVehicle() {
        if (vehicle != null) {
            System.out.println("Garrage starting vehicle of type: " + vehicle.vehicleType());
        } else {
            System.out.println("ERROR: Vehicle is null!");
        }
    }
}