package com.eurostar.utils;


import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class SelectUtils {


    public static void selectDropDownByVisibleText(WebElement webelement, String value) {
//        if (!StringUtils.isBlank(value)) {
            try {
                new Select(webelement).selectByVisibleText(value);
            } catch (Exception e) {
                throw new RuntimeException("could not select by visible text [" + value + "] in drop-down [" + webelement + "]", e);
            }
//        }
    }

    public static void selectDropDownByValue(WebElement webelement, String value) {
//        if (!StringUtils.isBlank(value)) {
            try {
                new Select(webelement).selectByValue(value);
            } catch (Exception e) {
                throw new RuntimeException("could not select by visible text [" + value + "] in drop-down [" + webelement + "]", e);
            }
//        }
    }
}
