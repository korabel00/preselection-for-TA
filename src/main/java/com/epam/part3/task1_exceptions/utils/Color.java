package com.epam.part3.task1_exceptions.utils;

public enum Color {

    //The constants for making text colorful in console
    ANSI_GREEN("\u001B[32m"),
    ANSI_YELLOW("\u001B[33m"),
    ANSI_RESET("\u001B[0m"),
    ANSI_BLACK("\u001B[37m"),
    ANSI_RED("\u001B[31m"),
    ANSI_BLUE("\u001B[34m");

    private final String code;

    Color(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}