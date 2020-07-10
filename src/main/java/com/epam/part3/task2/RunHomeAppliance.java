/*
 * Ilia Solovev. Task 2-1
 *
 * Спроектировать объектную модель для заданной предметной области.
 * Использовать (продемонстрировать умение работать):
 * - классы (abstract классы– по возможности),
 * - интерфейсы,
 * - наследование,
 * - полиморфизм,
 * - инкапсуляция,
 * - коллекции.
 *
 * Спроектировать объектную модель для заданной предметной области.
 * Домашняя техника. Определить иерархию ДТ. Включить некоторые в
 * розетку. Посчитать потребляемую мощность. Провести сортировку
 * приборов в квартире на основе одного из параметров. Найти кухонный
 * прибор в квартире, соответствующий заданному диапазону параметров.
 */

package com.epam.part3.task2;

import com.epam.part3.task2.home_appliances.*;
import com.epam.part3.task2.utils.Brand;
import com.epam.part3.task2.utils.SortArrayList;

import java.util.ArrayList;
import java.util.List;

public class RunHomeAppliance {

    public static void main(String[] args) {
        RunHomeAppliance app = new RunHomeAppliance();
        app.startApp();
    }

    //Running an application
    public void startApp() {

        int powerLessOrEqual = 300;

        List<HomeAppliances> homeAppliances = new ArrayList<>();

        createArrayOfHomeAppliance(homeAppliances);
        makeThemWorkAndShowPowerConsumption(homeAppliances);
        showThingsWithPowerLessOrEqualThanParam(homeAppliances, powerLessOrEqual);
        //Lets sort home appliances by power consumption
        SortArrayList.sortByPowerConsumption(homeAppliances);
    }

    private void createArrayOfHomeAppliance(List<HomeAppliances> homeAppliances) {

        TV tv = new TV(200, Brand.Samsung, "UE50NU7097U", 47);
        WashingMachine washingMachine = new WashingMachine(150, Brand.Indesit, "IWUB 4085", 1000);
        Computer computer = new Computer(400, Brand.DELL, "Vostro 3670");

        homeAppliances.add(tv);
        homeAppliances.add(washingMachine);
        homeAppliances.add(computer);
    }

    private void makeThemWorkAndShowPowerConsumption(List<HomeAppliances> homeAppliances) {

        int currentPowerConsumption = 0;

        for (HomeAppliances thing : homeAppliances) {
            //Every thing needs to be turned on - otherwise it won't work
            thing.turnOn();
            //Connecting every connectible thing to the WiFi
            thing.doWork();
            if (thing instanceof Connectible) {
                ((Connectible) thing).connectToWiFi();
            }
            //counting current home power consumption
            currentPowerConsumption += thing.getPowerConsumptionWhenOn();
        }

        System.out.println("Current power consumption is : " + currentPowerConsumption);
        // 600 is because the washing machine turned off automatically after finishing its work.
    }

    private void showThingsWithPowerLessOrEqualThanParam(List<HomeAppliances> homeAppliances, int powerLessOrEqualThanThat) {
        //Lets find all home appliances which are turned on and which power less or equal then param
        for (HomeAppliances thing : homeAppliances) {
            if (thing.isOn() && thing.getPowerConsumption() <= powerLessOrEqualThanThat) {
                System.out.println("Home appliance with power less or equal than " + powerLessOrEqualThanThat + " is: "
                        + thing.getClass().getSimpleName() + " " + thing.getBrand() + " " + thing.getModel());
            }
        }
    }

}
