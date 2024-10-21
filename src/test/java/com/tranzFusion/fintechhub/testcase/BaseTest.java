package com.tranzFusion.fintechhub.testcase;
import com.tranzFusion.fintechhub.page.BasePage;
import com.tranzFusion.fintechhub.page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;
    Page page;
    @BeforeMethod
    public void setupBrowser(){
        driver=new FirefoxDriver();
        //driver.get("http://192.168.10.33/Source/TranzFusion/TranzFusionTest/TranzFusionWindowTest/TranzFusionWindow//SessionExpire.aspx");
        driver.get("http://192.168.10.33/Source/TranzFusion/TranzFusionTest/TranzFusionWindowTest/TranzFusionWindow/Login.aspx");
        driver.manage().window().maximize();
        page=new BasePage(driver);

    }
    @AfterMethod
    public void tearDown(){
       driver.quit();
    }

}
