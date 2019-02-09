package com.jurik99.Facade;

import com.jurik99.Facade.carsystem.AirFlowController;
import com.jurik99.Facade.carsystem.CatalyticConverter;
import com.jurik99.Facade.carsystem.CoolingController;
import com.jurik99.Facade.carsystem.FuelInjector;
import com.jurik99.Facade.carsystem.Starter;

public class Facade {

    private static final Integer DEFAULT_COOLING_TEMP = 90;
    private static final Integer MAX_ALLOWED_TEMP = 50;
    private final FuelInjector fuelInjector = new FuelInjector();
    private final AirFlowController airFlowController = new AirFlowController();
    private final Starter starter = new Starter();
    private final CoolingController coolingController = new CoolingController();
    private final CatalyticConverter catalyticConverter = new CatalyticConverter();

    void startEngine() {
        fuelInjector.on();
        airFlowController.takeAir();
        fuelInjector.on();
        fuelInjector.inject();
        starter.start();
        coolingController.setTemperatureUpperLimit(DEFAULT_COOLING_TEMP);
        coolingController.run();
        catalyticConverter.on();
    }

    void stopEngine() {
        fuelInjector.off();
        catalyticConverter.off();
        coolingController.cool(MAX_ALLOWED_TEMP);
        coolingController.stop();
        airFlowController.off();
    }
}
