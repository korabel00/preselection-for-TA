package com.epam.part3.task2_IOstreams.home_appliances;

import com.epam.part3.task2_IOstreams.utils.Brand;

public class Computer extends HomeAppliances implements Connectible {

    public Computer(int powerConsumption, Brand brand, String model) {
        super(powerConsumption, brand, model);
    }

    @Override
    public void doWork() {
        if (this.isOn()) {
            System.out.println("I'm a Computer - Crunching numbers");
        } else {
            System.out.println("First of all, you need to turn me on");
        }
    }

    @Override
    public void connectToWiFi() {
        System.out.println("The Computer is connecting to the WiFi...");
    }
}
