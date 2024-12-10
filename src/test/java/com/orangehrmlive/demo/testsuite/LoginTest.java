package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customelisteners.CustomListeners;
import com.orangehrmlive.demo.pages.AdminPage;
import com.orangehrmlive.demo.pages.DashboardPage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;


@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    AdminPage adminPage = new AdminPage();



    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldLoginSuccessFully(){



        //Enter username
        loginPage.enterUsername("Admin");

        //Enter password
        loginPage.enterPassword("admin123");

        //Click on Login Button
        loginPage.clickOnLoginButton();

        //Verify "Dashboard" Message
        String expectedMessage = "Dashboard";
        String actualMessage = dashboardPage.getDashboardText();
        Assert.assertEquals(actualMessage, expectedMessage, "Invalid Message Display");


    }

    @Test(groups = {"smoke", "regression"})
    public void VerifyThatTheLogoDisplayOnLoginPage(){


        //Launch the application


        //Verify Logo is Displayed
        Assert.assertTrue(loginPage.displayLogo());
    }
    @Test(groups = {"regression"})
    public void VerifyUserShouldLogOutSuccessFully(){



        //Login To The application
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();


        //Click on User Profile logo
        adminPage.clickOnUserId();

        //Mouse hover on "Logout" and click
        adminPage.hoverOnLogout();

        //Verify the text "Login Panel" is displayed
//       String expectedText = "Login";
//       String actualText = loginPage.verifyLoginPanelText();
//       Assert.assertEquals(actualText, expectedText, "Invalid Text Display");

    }

    @Test(groups = {"regression"}, dataProvider = "invalidCredentials", dataProviderClass = TestData.class)
    public void verifyErrorMessageWithInvalidCredentials(String username, String password, String errorMessage){


        //Enter username <username>
        loginPage.userName(username);

        //Enter password <password>
        loginPage.passwordName(password);

        //Click on Login Button
        loginPage.clickOnLoginButton();

        //Verify Error message <errorMessage>
        Assert.assertEquals(loginPage.getLoginErrorMsg(), errorMessage);




    }
}
