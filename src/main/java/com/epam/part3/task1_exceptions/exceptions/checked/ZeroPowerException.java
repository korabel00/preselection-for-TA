package com.epam.part3.task1_exceptions.exceptions.checked;

import com.epam.part3.task1_exceptions.home_appliances.HomeAppliances;
import com.epam.part3.task1_exceptions.utils.Color;

final public class ZeroPowerException extends Checked {

    public void showMessageIfPowerIsZero(HomeAppliances homeAppliances, int defaultPower) {
        System.out.println(Color.ANSI_RED.getCode() + "You cannot create an appliance with power consumption <= 0. The power of your " +
                homeAppliances.getClass().getSimpleName() + " will be set on the default number " + defaultPower +
                Color.ANSI_RESET.getCode());
    }
}
