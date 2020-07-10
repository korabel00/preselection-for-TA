package com.epam.part3.task2.utils;

import com.epam.part3.task2.home_appliances.HomeAppliances;

import java.util.Comparator;
import java.util.List;

public class SortArrayList {

    public static Comparator<HomeAppliances> POWER = new Comparator<>() {

        @Override
        public int compare(HomeAppliances ha1, HomeAppliances ha2) {
            return ha1.getPowerConsumption() - ha2.getPowerConsumption();
        }
    };

    public static void sortByPowerConsumption(List<HomeAppliances> arrayList) {

        arrayList.sort(SortArrayList.POWER);
        output(arrayList);
    }

    private static void output(List<HomeAppliances> arrayList) {
        //And output the result with class names
        System.out.println("Sorted list of home appliances by power consumption (ascending):");
        for (HomeAppliances thing : arrayList) {
            System.out.println(thing.getClass().getSimpleName());
        }
    }
}
