package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilites.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ViewSystemUsersPage extends Utilities {



    @CacheLookup
    @FindBy(css = "div[class='oxd-table-card-cell-checkbox'] i[class='oxd-icon bi-check oxd-checkbox-input-icon']\"")
    WebElement checkbox;

    @CacheLookup
    @FindBy(css = "//div[@class='orangehrm-container']//button[1]")
    WebElement deleteButton;

    @CacheLookup
    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
    WebElement okAlert;



    /**
     * This method will click on checkbox
     */
    public void clickOnCheckbox(){
        clickOnElement(checkbox);
    }
    /**
     * This method will click delete button
     */
    public void clickOnDeleteButton(){
        clickOnElement(deleteButton);
    }
    /**
     * This method will click ok on pop up
     */
    public void clickOkOnPopUP(){
        acceptAlert();
    }



    By systemUserText = By.xpath("//h5[normalize-space()='System Users']");
    By addTab = By.xpath("//button[normalize-space()='Add']");
    By enterUser = By.cssSelector("body div div div div div div div form div div div div div input:nth-child(1)");
    By userRole = By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]");
    By statusTab = By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > i:nth-child(1)");
    By searchTab = By.cssSelector("button[type='submit']");
    public String getTextSystemUser(){
        return getTextFromElement(systemUserText);
    }

    public void clickOnAddTab(){
        clickOnElement(addTab);
    }
    public void enterUserName(String name){
        sendTextToElement(enterUser, name);
    }
    public void selectTheUserTab(){
        WebElement userRoleTab = driver.findElement(userRole);
        Select select = new Select(userRoleTab);
        select.selectByVisibleText("Admin");
    }
    public void selectTheStatusTab(){
        WebElement statusRoleTab = driver.findElement(statusTab);
        Select select = new Select(statusRoleTab);
        select.selectByVisibleText("Disabled");
    }
    public void clickOnSearchTab(){
        clickOnElement(searchTab);
    }


}
