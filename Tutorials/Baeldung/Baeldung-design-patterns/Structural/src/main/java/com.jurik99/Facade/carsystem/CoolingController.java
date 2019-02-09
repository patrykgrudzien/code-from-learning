package com.jurik99.Facade.carsystem;

public class CoolingController {

    private static final Integer DEFAULT_RADIATOR_SPEED = 10;

    private Integer temperatureUpperLimit;
    private final Radiator radiator = new Radiator();
    private final TemperatureSensor temperatureSensor = new TemperatureSensor();

    public void setTemperatureUpperLimit(final Integer temperatureUpperLimit) {
        System.out.println("Setting temperature upper limit to " + temperatureUpperLimit);
        this.temperatureUpperLimit = temperatureUpperLimit;
    }

    public void run() {
        System.out.println("Cooling Controller ready!");
        radiator.setSpeed(DEFAULT_RADIATOR_SPEED);
    }

    public void cool(final Integer maxAllowedTemp) {
        System.out.println("Scheduled cooling with maximum allowed temperature " + maxAllowedTemp);
        temperatureSensor.getTemperature();
        radiator.on();
    }

    public void stop() {
        System.out.println("Stopping Cooling Controller..");
        radiator.off();
    }
}
