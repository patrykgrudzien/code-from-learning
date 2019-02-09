package com.jurik99.Facade.carsystem;

public class AirFlowController {

    private final AirFlowMeter airFlowMeter = new AirFlowMeter();

    public void takeAir() {
        airFlowMeter.getMeasurements();
        System.out.println("Air provided!");
    }

    public void off() {
        System.out.println("Air controller switched off.");
    }
}
