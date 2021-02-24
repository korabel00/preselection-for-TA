
package com.epam.part3.task1_exceptions.home_appliances;


import com.epam.part3.task1_exceptions.exceptions.checked.ApplianceIsOffException;
import com.epam.part3.task1_exceptions.exceptions.checked.WrongScreenSizeException;
import com.epam.part3.task1_exceptions.utils.Brand;

public class TV extends HomeAppliances implements Connectible {

    private final int screenSize;
    private final int defaultScreenSize = 32;

    public TV(int powerConsumption, Brand brand, String model, int screenSize) throws WrongScreenSizeException {
        super(powerConsumption, brand, model);

        if (screenSize <= 0) {
            try {
                throw new WrongScreenSizeException();
            } finally {
                this.screenSize = defaultScreenSize;
            }
        } else {
            this.screenSize = screenSize;
        }
    }

    @Override
    public void doWork() {
        if (this.isOn()) {
            System.out.println("I'am a TV - Showing you Game of Thrones. It is so nice to watch it on a " + screenSize +
                    " inches screen, isn't?");
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
        System.out.println("The TV is connecting to the WiFi...");
    }
}
