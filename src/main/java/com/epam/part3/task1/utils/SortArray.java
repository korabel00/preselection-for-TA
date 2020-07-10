package com.epam.part3.task1.utils;

import com.epam.part3.task1.home_appliances.HomeAppliances;

import java.util.Arrays;
import java.util.Comparator;

public class SortArray {


    public static Comparator<HomeAppliances> POWER = new Comparator<HomeAppliances>() {

        @Override
        public int compare(HomeAppliances ha1, HomeAppliances ha2) {
            return ha1.getPowerConsumption() - ha2.getPowerConsumption();
        }
    };

    public static void sortByPowerConsumption(HomeAppliances[] array) {

        Arrays.sort(array, SortArray.POWER);
        output(array);
    }

    private static void output(HomeAppliances[] arrayList) {
        //And output the result with class names
        System.out.println("Sorted list of home appliances by power consumption (ascending):");
        for (HomeAppliances thing : arrayList) {
            System.out.println(thing.getClass().getSimpleName());
        }
    }

}
