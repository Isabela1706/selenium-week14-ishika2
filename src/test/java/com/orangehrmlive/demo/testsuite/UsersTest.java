package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customelisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class UsersTest extends BaseTest {

    LoginPage loginPage;
    AdminPage adminPage;
    ViewSystemUsersPage systemUsersPage;
    AddUserPage addUserPage ;


    @BeforeMethod
    public void inIt(){
        loginPage = new LoginPage();
        adminPage = new AdminPage();
        systemUsersPage = new ViewSystemUsersPage();
        addUserPage = new AddUserPage();
    }


    @Test(groups = {"sanity", "smoke", "regression"})
    public void adminShouldAddUserSuccessFully(){

        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();

        //click On "Admin" Tab
        adminPage.clickOnAdminTab();

        //Verify "System Users" Text
        String expectedText = "System Users";
        String actualText = systemUsersPage.getTextSystemUser();
        Assert.assertEquals(actualText, expectedText, "Wrong Text display");

        //click On "Add" button
        systemUsersPage.clickOnAddTab();

        //Verify "Add User" Text
       String expectedAddText = "Add User";
       String actualAddText = addUserPage.getTextAddUser();
        Assert.assertEquals(actualAddText, expectedAddText, "Wrong Text display");

        //Select User Role "Admin"
        addUserPage.selectTheUserRole("Admin");

        //enter Employee Name "Ananya Dash"
        addUserPage.enterEmployeeName("Thomas Kutty Benny");

        //enter Username
        addUserPage.enterEmployeeUsername("@123456");

        //Select status "Disable"
        addUserPage.selectTheDisableTab("Disabled");

        //enter psaaword
        addUserPage.enterPasswordField("Thomas123");

        //enter Confirm Password
        addUserPage.enterConfirmPasswordField("Thomas123");

        //click On "Save" Button
        addUserPage.clickOnTheSaveTab();



    }
    @Test(groups = {"smoke", "regression"})
    public void searchTheUserCreatedAndVerifyIt(){

        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();

        //click On "Admin" Tab
        adminPage.clickOnAdminTab();

        //Verify "System Users" Text
        String expectedText = "System Users";
        String actualText = systemUsersPage.getTextSystemUser();
        Assert.assertEquals(actualText, expectedText, "Wrong Text display");


        //Enter Username
        systemUsersPage.enterUserName("Judy.Morgan");


        //Select User Role
        systemUsersPage.selectTheUserTab();

        //Select Satatus
        systemUsersPage.selectTheStatusTab();

        //Click on "Search" Button
        systemUsersPage.clickOnSearchTab();

        //Verify the User should be in Result list.
        String expectedRecord = "No Records Found";
        String actualRecord = adminPage.getNoRecordFound();
        Assert.assertEquals(actualRecord, expectedRecord, "Wrong Text display");




    }
    @Test(groups = {"regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully(){


        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();

        //click On "Admin" Tab
        adminPage.clickOnAdminTab();

        //Verify "System Users" Text
        String expectedText = "System Users";
        String actualText = systemUsersPage.getTextSystemUser();
        Assert.assertEquals(actualText, expectedText, "Wrong Text display");


        //Enter Username
        systemUsersPage.enterUserName("anaya");


        //Select User Role
        systemUsersPage.selectTheUserTab();

        //Select Satatus
        systemUsersPage.selectTheStatusTab();

        //Click on "Search" Button
        systemUsersPage.clickOnSearchTab();


        //	Click on Check box
        systemUsersPage.clickOnCheckbox();

        //	Click on Delete Button
        systemUsersPage.clickOnDeleteButton();

        //	Popup will display


        //	Click on Ok Button on Popup
        systemUsersPage.acceptAlert();

    }

    @Test(groups = {"regression"})
    public void searchTheUserAndVerifyTheMessageRecordFound(){



        //Login to Application
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();


        //click On "Admin" Tab
        adminPage.clickOnAdminTab();

        //Verify "System Users" Text
        String expectedText = "System Users";
        String actualText = systemUsersPage.getTextSystemUser();
        Assert.assertEquals(actualText, expectedText, "Wrong Text display");


        //	Enter Username
        addUserPage.enterUserName("Thomas");

        //	Select User Role
        //	Select Satatus
        //	Click on "Search" Button
        addUserPage.clickOnSearchButton();

        //	verify message "No Records Found"
        addUserPage.verifyNoUserFound();



    }
}
