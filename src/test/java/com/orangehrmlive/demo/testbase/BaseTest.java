package com.orangehrmlive.demo.testbase;


import com.orangehrmlive.demo.propertyreader.PropertyReader;
import com.orangehrmlive.demo.utilites.Utilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest extends Utilities {

    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        selectBrowser(browser);
    }



    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        closeBrowser();
    }


}
