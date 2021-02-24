/*
 * Ilia Solovev. Task 1
 *
 * Написать калькулятор – коносольное приложение (реализовать как минимум 4 операции)
 * («+» -  * сложение, «-» - вычитание, «*» - умножение, «/» - деление) и выводит результат в
 * консоль.
 */

package com.epam.part1.task1_calc;

import java.util.Scanner;

public class Calculator {

    int numberOne;
    int numberTwo;
    String operation;
    float mathResult;

    public static void main(String[] args) {
        Calculator app = new Calculator();
        app.startCalculator();
    }

    //Running an application
    private void startCalculator() {

        while (true) {
            getUserNumbersAndOperation();
            if ("Q".equalsIgnoreCase(operation)) {
                break;
            }
            doMath();
            outputResult();
        }
    }

    //Getting two numbers and operation value
    private void getUserNumbersAndOperation() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter two numbers:");
        numberOne = scanner.nextInt();
        numberTwo = scanner.nextInt();

        System.out.println("Please, enter an arithmetic operation (+, -, * , /) or enter \"Q\" " +
                "if you don't want to continue:");
        scanner.nextLine();
        operation = scanner.nextLine();

    }

    //Choice of a method depends on operation
    private void doMath() {

        switch (operation) {
            case "+":
                doAddition();
                break;
            case "-":
                doSubtraction();
                break;
            case "*":
                doMultiplication();
                break;
            case "/":
                doDivision();
                break;
            case "Q":
                break;
            default:
                System.out.println("There is no such operation");
        }
    }

    private void doAddition() {
        mathResult = numberOne + numberTwo;
    }

    private void doSubtraction() {
        mathResult = numberOne - numberTwo;
    }

    private void doMultiplication() {
        mathResult = numberOne * numberTwo;
    }

    private void doDivision() {
        if (numberTwo == 0) {
            System.out.println("You cannot divide by zero");
        } else {
            mathResult = (float) numberOne / numberTwo;
        }
    }

    private void outputResult() {
        System.out.println("The result is: " + mathResult);
    }
}
