package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customelisteners.CustomListeners;
import com.orangehrmlive.demo.utilites.Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utilities {


    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Username']\")")
    WebElement storeUsername;


    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;


    @CacheLookup
    @FindBy(xpath = "//body/div/div/div/div/img[1]")
    WebElement hrForAllLogo;


    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement loginErrorMessage;


    public void enterUsername(String value){
        sendTextToElement(storeUsername, value);
        Reporter.log("enter " + value);
        CustomListeners.test.log(Status.PASS, "enter " + value);
    }

    public void enterPassword(String value){
        sendTextToElement(passwordField, value);
        Reporter.log("enter " + value);
        CustomListeners.test.log(Status.PASS, "enter " + value);

    }

    public void clickOnLoginButton(){
        clickOnElement(loginButton);
        Reporter.log("click on " + loginButton);
        CustomListeners.test.log(Status.PASS, "click on " + loginButton);
    }

    public String getHRForAllLogo(){
        return getTextFromElement(hrForAllLogo);
    }

//    public  String verifyLoginPanelText(){
//        return getTextFromElement(logInPanelText);
//    }
    public boolean displayLogo(){
        return true;
    }



    public void userName(String username) {
        enterUsername(username);
    }

    public void passwordName(String password) {
        enterPassword(password);
    }
    public void clickOnLogIn(){
        clickOnLoginButton();
    }
    public String getLoginErrorMsg() {
        Reporter.log("get " + loginErrorMessage);
        CustomListeners.test.log(Status.PASS, "get " + loginErrorMessage);
        return getTextFromElement(loginErrorMessage);
    }







}
