package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customelisteners.CustomListeners;
import com.orangehrmlive.demo.utilites.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Reporter;

public class AddUserPage extends Utilities {

//    By addTabText = By.xpath("//h6[normalize-space()='Add User']");
    @CacheLookup
    @FindBy(xpath = "//h6[normalize-space()='Add User']")
    WebElement addTabText;

//    By userRole = By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)");
    @CacheLookup
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)")
    WebElement userRole;


//    By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeName;

//    By employeeUsername = By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)");
    @CacheLookup
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
    WebElement employeeUsername;

//    By disableTab = By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]");
    @CacheLookup
    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")
    WebElement disableTab;

//    By enterPassword = By.cssSelector("div.oxd-layout.orangehrm-upgrade-layout div.oxd-layout-container div.oxd-layout-context div.orangehrm-background-container div.orangehrm-card-container form.oxd-form div.oxd-form-row.user-password-row:nth-child(2) div.oxd-grid-2.orangehrm-full-width-grid div.oxd-grid-item.oxd-grid-item--gutters.user-password-cell:nth-child(1) div.oxd-input-group.oxd-input-field-bottom-space div:nth-child(2) > input.oxd-input.oxd-input--active");
    @CacheLookup
    @FindBy(css = "div.oxd-layout.orangehrm-upgrade-layout div.oxd-layout-container div.oxd-layout-context div.orangehrm-background-container div.orangehrm-card-container form.oxd-form div.oxd-form-row.user-password-row:nth-child(2) div.oxd-grid-2.orangehrm-full-width-grid div.oxd-grid-item.oxd-grid-item--gutters.user-password-cell:nth-child(1) div.oxd-input-group.oxd-input-field-bottom-space div:nth-child(2) > input.oxd-input.oxd-input--active")
    WebElement enterPassword;

//    By confirmPassword = By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)");
    @CacheLookup
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
    WebElement confirmPassword;


//    By saveTab = By.cssSelector("button[type='submit']");
    @CacheLookup
    @FindBy(css= "button[type='submit']")
    WebElement saveTab;

    By userName= RelativeLocator.with(By.tagName("input")).below(By.xpath("//label[normalize-space()='Username']"));

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-toast oxd-toast--info oxd-toast-container--toast']")
    WebElement noRecordFound;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement searchButton;



    public void enterUserName(String uName){
        sendTextToElement(userName,uName);
    }

    public String getTextAddUser(){
        return getTextFromElement((By) addTabText);
    }
    public void selectTheUserRole(String role){
        mouseHoverToElementAndClick((By) userRole);
        typeKeysAndEnter(role.split("")[0]);
    }
    public void enterEmployeeName(String name){
        sendTextToElement(employeeName, name);
        Reporter.log("enter " + employeeName);
        CustomListeners.test.log(Status.PASS, "enter " + employeeName);

    }
    public void enterEmployeeUsername(String name){
        sendTextToElement(employeeUsername, name);

    }
    public void selectTheDisableTab(String status){
        mouseHoverToElementAndClick((By) disableTab);
      typeKeysAndEnter(status.split("")[0]);
    }

    public void enterPasswordField(String name){
        sendTextToElement(enterPassword, name);

    }
    public void enterConfirmPasswordField(String name){
        sendTextToElement(confirmPassword, name);

    }
    public void clickOnTheSaveTab(){
        clickOnElement(saveTab);
    }

    public String verifyNoUserFound(){
        return getTextFromElement(noRecordFound);
    }
    public void clickOnSearchButton(){
        clickOnElement(searchButton);
    }

}
