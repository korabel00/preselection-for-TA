package com.epam.part3.task1_exceptions.exceptions.checked;

import com.epam.part3.task1_exceptions.utils.Color;

final public class BadCompareException extends Checked {

    public void showMessageIfBadCompare(int powerLessOrEqualThanThat) {
        System.out.println(Color.ANSI_RED.getCode() + "There are no appliances with power less <= "
                + powerLessOrEqualThanThat + Color.ANSI_RESET.getCode());
    }
}
