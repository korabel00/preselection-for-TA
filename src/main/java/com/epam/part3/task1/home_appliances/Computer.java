package com.epam.part3.task1.home_appliances;

import com.epam.part3.task1.exceptions.checked.ApplianceIsOffException;
import com.epam.part3.task1.utils.Brand;

public class Computer extends HomeAppliances implements Connectible {

    public Computer(int powerConsumption, Brand brand, String model) {
        super(powerConsumption, brand, model);
    }

    @Override
    public void doWork() {
        if (this.isOn()) {
            System.out.println("I'm a Computer - Crunching numbers");
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

    @Override
    public void connectToWiFi() {
        System.out.println("The Computer is connecting to the WiFi...");
    }
}
