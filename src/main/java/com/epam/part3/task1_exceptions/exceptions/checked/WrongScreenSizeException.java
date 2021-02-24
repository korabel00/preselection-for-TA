package com.epam.part3.task1_exceptions.exceptions.checked;

import com.epam.part3.task1_exceptions.utils.Color;

final public class WrongScreenSizeException extends Checked {

    public void showWrongScreenSizeMessage() {
        System.out.println(Color.ANSI_RED.getCode() + "Wrong screen size of a TV" + Color.ANSI_RESET.getCode());
    }
}
