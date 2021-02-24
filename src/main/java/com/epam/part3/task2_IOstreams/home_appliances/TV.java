package com.epam.part3.task2_IOstreams.home_appliances;

import com.epam.part3.task2_IOstreams.utils.Brand;

public class TV extends HomeAppliances implements Connectible {

    private final int screenSize;

    public TV(int powerConsumption, Brand brand, String model, int screenSize) {
        super(powerConsumption, brand, model);
        this.screenSize = screenSize;
    }

    @Override
    public void doWork() {
        if (this.isOn()) {
            System.out.println("I'am a TV - Showing you Game of Thrones. It is so nice to watch it on a " + screenSize +
                    " inches screen, isn't?");
        } else {
            System.out.println("First, you need to turn me on");
        }
    }

    @Override
    public void connectToWiFi() {
        System.out.println("The TV is connecting to the WiFi...");
    }
}
