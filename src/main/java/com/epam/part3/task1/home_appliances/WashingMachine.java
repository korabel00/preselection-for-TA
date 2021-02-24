package com.epam.part3.task1.home_appliances;


import com.epam.part3.task1.exceptions.checked.ApplianceIsOffException;
import com.epam.part3.task1.utils.Brand;

public class WashingMachine extends HomeAppliances {

    private final int rpm;

    public WashingMachine(int powerConsumption, Brand brand, String model, int rpm) {
        super(powerConsumption, brand, model);
        this.rpm = rpm;
    }

    @Override
    public void doWork() {
        if (this.isOn()) {
            System.out.println("I'm a Washing Machine - Washing your cloth with " + rpm + " RPM.");
        } else {
            try {
                throw new ApplianceIsOffException();
            } catch (ApplianceIsOffException e) {
                e.showTurnMeOnMessage(this);
            } finally {
                this.turnOn();
            }
        }
    }
}
