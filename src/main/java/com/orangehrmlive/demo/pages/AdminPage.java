package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customelisteners.CustomListeners;
import com.orangehrmlive.demo.utilites.Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AdminPage extends Utilities {


    @CacheLookup
    @FindBy(css = "body div div div header div div ul li span p")
    WebElement userId;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutButton;


    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Admin']")
    WebElement adminTab;


    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='No Records Found']")
    WebElement noRecordFound;







    public void clickOnUserId(){
        clickOnElement(userId);
        Reporter.log("click " + userId);
        CustomListeners.test.log(Status.PASS, "click " + userId);
    }
    public void hoverOnLogout(){
        mouseHoverToElementAndClick(logoutButton);
        Reporter.log("click " + logoutButton);
        CustomListeners.test.log(Status.PASS, "click " + logoutButton);

    }
    public void clickOnAdminTab(){
        clickOnElement(adminTab);
        Reporter.log("click " + adminTab);
        CustomListeners.test.log(Status.PASS, "click " + adminTab);
    }
    public String getNoRecordFound(){
        Reporter.log("get " + noRecordFound);
        CustomListeners.test.log(Status.PASS, "get " + noRecordFound);
        return getTextFromElement(noRecordFound);
    }
}
