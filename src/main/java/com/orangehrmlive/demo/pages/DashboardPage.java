package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilites.Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends Utilities {

    @CacheLookup
    @FindBy(xpath= "//h6")
    WebElement dashboardText;




    public String getDashboardText(){
        return getTextFromElement(dashboardText);
    }
}
