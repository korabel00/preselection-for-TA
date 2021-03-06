package com.epam.part3.task1_exceptions.exceptions.checked;

import com.epam.part3.task1_exceptions.home_appliances.HomeAppliances;
import com.epam.part3.task1_exceptions.utils.Color;

final public class ApplianceIsOffException extends Checked {

    public void showTurnMeOnMessage(HomeAppliances homeAppliances) {
        System.out.println(Color.ANSI_RED.getCode() + "Before doing work " + homeAppliances.getClass().getSimpleName() +
                " needs to be turned on. But ok, I will do it for you." + Color.ANSI_RESET.getCode());
    }
}
