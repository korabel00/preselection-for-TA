package com.epam.part2.task1_oop.home_appliances;

import com.epam.part2.task1_oop.utils.Brand;

public abstract class HomeAppliances {

    private final int powerConsumption;
    private final Brand brand;
    private final String model;
    private int powerConsumptionWhenOn;
    private boolean on;


    public HomeAppliances(int powerConsumption, Brand brand, String model) {
        this.powerConsumption = powerConsumption;
        this.brand = brand;
        this.model = model;
    }

    public void turnOn() {
        this.on = true;
        this.powerConsumptionWhenOn = powerConsumption;
    }

    public void turnOff() {
        this.on = false;
        this.powerConsumptionWhenOn = 0;
    }

    public abstract void doWork();

    public boolean isOn() {
        return on;
    }

    public String getModel() {
        return model;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public int getPowerConsumptionWhenOn() {
        return powerConsumptionWhenOn;
    }

    public Brand getBrand() {
        return brand;
    }
}

