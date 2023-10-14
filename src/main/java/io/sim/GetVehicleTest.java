package io.sim;

import java.io.IOException;

import sim.traci4j.src.java.it.polito.appeal.traci.SumoTraciConnection;
import sim.traci4j.src.java.it.polito.appeal.traci.Vehicle;

public class GetVehicleTest {
    
    public static void main(String[] args) {
        SumoTraciConnection sumo = new SumoTraciConnection(
        "map\\map.sumo.cfg",
        (int) System.nanoTime());
        sumo.addOption("start", "1");
        sumo.addOption("quit-on-end", "1");
        try {
            sumo.runServer();
        } catch (IOException | InterruptedException e) {e.printStackTrace();}
    }
    
}