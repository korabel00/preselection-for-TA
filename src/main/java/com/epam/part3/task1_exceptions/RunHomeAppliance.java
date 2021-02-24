/*
 * Ilia Solovev. Task 3-1
 *
 * Спроектировать иерархию исключительных ситуаций для объектной модели,
 * выбранной в предыдущем домашнем задании.
 */

package com.epam.part3.task1_exceptions;

import com.epam.part3.task1_exceptions.exceptions.checked.BadCompareException;
import com.epam.part3.task1_exceptions.exceptions.checked.WrongScreenSizeException;
import com.epam.part3.task1_exceptions.home_appliances.*;
import com.epam.part3.task1_exceptions.utils.Brand;
import com.epam.part3.task1_exceptions.utils.Color;
import com.epam.part3.task1_exceptions.utils.SortArray;

public class RunHomeAppliance {

    public static void main(String[] args) {
        RunHomeAppliance app = new RunHomeAppliance();
        app.startApp();
    }

    //Running an application
    public void startApp() {

        // 1 case of exceptions (Checked) - You cannot create an appliance with power <= 0
        int[] powerOfThings = new int[]{0, 200, 400};
        int powerToCompare = 5;
        int numberOfAppliance = 3;

        HomeAppliances[] homeAppliances = new HomeAppliances[numberOfAppliance];
        createArrayOfHomeAppliance(homeAppliances, powerOfThings);
        makeThemWorkAndShowPowerConsumption(homeAppliances);

        // multicatch
        try {
            // 2 case of exceptions (Checked)- trying to create a TV with a screen size 0 - ApplianceException wll work
            TV tvLG = new TV(230, Brand.LG, "55sm8200pla", 0);
            // 3 case of exceptions (Unchecked)- trying to put 4th elements into array of 3
            // If you set screen size > 0 than ArrayIndexOutOfBoundsException will work
            homeAppliances[3] = tvLG;
        } catch (WrongScreenSizeException e) {
            e.showWrongScreenSizeMessage();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(Color.ANSI_RED.getCode() + "You are trying to add an appliance, but there is no place for it: " +
                    e.getMessage() + Color.ANSI_RESET.getCode());
        }

        // 4 case of exceptions (Checked)- you cannot make appliance work if it is not turned ON.
        homeAppliances[2].turnOff();
        homeAppliances[2].doWork();

        // 5 case of exceptions (Checked) - When there are no appliance with power <= powerToCompare
        showThingsWithPowerLessOrEqualThanParam(homeAppliances, powerToCompare);
        SortArray.sortByPowerConsumption(homeAppliances);
    }

    private void createArrayOfHomeAppliance(HomeAppliances[] homeAppliances, int[] powerOfThings) {

        TV tv = null;
        try {
            tv = new TV(powerOfThings[0], Brand.Samsung, "UE50NU7097U", 47);
        } catch (WrongScreenSizeException e) {
            e.showWrongScreenSizeMessage();
        }
        WashingMachine washingMachine = new WashingMachine(powerOfThings[1], Brand.Indesit, "IWUB 4085", 1000);
        Computer computer = new Computer(powerOfThings[2], Brand.DELL, "Vostro 3670");

        homeAppliances[0] = tv;
        homeAppliances[1] = washingMachine;
        homeAppliances[2] = computer;
    }

    private void makeThemWorkAndShowPowerConsumption(HomeAppliances[] homeAppliances) {

        int currentPowerConsumption = 0;

        for (HomeAppliances appliance : homeAppliances) {
            //Every appliance needs to be turned on - otherwise it won't work
            appliance.turnOn();
            //Connecting every connectible appliance to the WiFi
            appliance.doWork();

            if (appliance instanceof Connectible) {
                ((Connectible) appliance).connectToWiFi();
            }
            //counting current home power consumption
            currentPowerConsumption += appliance.getPowerConsumptionWhenOn();
        }
        System.out.println(Color.ANSI_BLUE.getCode() + "Showing you power consumption of all home..." +
                Color.ANSI_RESET.getCode());
        System.out.println("Current power consumption is : " + currentPowerConsumption);
    }

    private void showThingsWithPowerLessOrEqualThanParam(HomeAppliances[] homeAppliances, int powerToCompare) {

        int count = 0;

        System.out.println("Trying to find things with power <= " + powerToCompare + "...");

        //Lets find all home appliances which are turned on and which power less or equal then param
        for (HomeAppliances thing : homeAppliances) {
            if (thing.isOn() && thing.getPowerConsumption() <= powerToCompare) {
                System.out.println("Home appliance with power less or equal than " + powerToCompare + " is: "
                        + thing.getClass().getSimpleName() + " " + thing.getBrand() + " " + thing.getModel());
                count++;
            }
        }

        if (count == 0) {
            try {
                throw new BadCompareException();
            } catch (BadCompareException e) {
                e.showMessageIfBadCompare(powerToCompare);
            }
        }
    }
}
