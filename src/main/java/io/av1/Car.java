package io.av1;

import de.tudresden.sumo.cmd.Vehicle;
import it.polito.appeal.traci.SumoTraciConnection;

public class Car extends Thread {

    private SumoTraciConnection sumo;
    private String idCar;

    public Car(SumoTraciConnection sumo, String idCar) {
        this.sumo = sumo;
        this.idCar = idCar;
        addCar();
    }

    private void addCar() {
        try {
            sumo.do_job_set(Vehicle.addFull(this.idCar, 
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

    public void SysOut() {
        System.out.println((String) this.sumo.do_job_get(Vehicle.getRoadID(this.idAuto)));
    }

    @Override
    public void run(){
        while (true) {
            SysOut();
            Thread.sleep(1000);
        }
    }
}
