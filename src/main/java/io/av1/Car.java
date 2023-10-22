package io.av1;

import de.tudresden.sumo.cmd.Vehicle;
import it.polito.appeal.traci.SumoTraciConnection;

public class Car extends Vehicle {

    private SumoTraciConnection sumo;

    public Car(SumoTraciConnection sumo) {
        this.sumo = sumo;
        addCar();
    }

    private void addCar() {
        try {
            sumo.do_job_set(Vehicle.addFull("CarTest", 
                                            "0",
                                            "DEFAULT_VEHTYPE", 					//typeID 
											"now", 								//depart  
											"0", 								//departLane 
											"0", 								//departPos 
											"0",								//departSpeed
											"current",							//arrivalLane 
											"max",								//arrivalPos 
											"current",							//arrivalSpeed 
											"",									//fromTaz 
											"",									//toTaz 
											"",
                                            1, 
                                            1)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
