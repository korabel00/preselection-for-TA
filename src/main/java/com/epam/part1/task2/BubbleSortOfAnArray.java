/*
 * Ilia Solovev. Task 2
 *
 * Отсортировать массив по длине строк
 *
 */

package com.epam.part1.task2;


public class BubbleSortOfAnArray {

    public static void main(String[] args) {

        String[] arrayOfStrings = new String[] {"Bartholomew", "Augustin", "Jo", "Cameron", "Carl", "Ethan"};
        sortAnArrayByStringLengthASC(arrayOfStrings);
    }

    public static void sortAnArrayByStringLengthASC(String[] array) {

        boolean needIteration = true;

        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i].length() < array[i - 1].length()) {
                    swap(array, i, i - 1);
                    needIteration = true;
                }
            }
        }
        output(array);
    }

    private static void swap(String[] array, int indexOne, int indexTwo) {
        String temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

    private static void output(String[] array) {
        //And output the result with class names
        System.out.println("Sorted list of strings by their lenght (ascending):");
        for (String string : array) {
            System.out.println(string);
        }
    }
}
