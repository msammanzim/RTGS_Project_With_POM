package com.tranzFusion.fintechhub.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public boolean hasBankName(){
      return   getWebElements(By.xpath("//span[@id='contPlcHdrMasterHolder_bankName']")).size()>0;
    }

    public void clickLogOut(){
        //getWebElement(By.xpath("//*[name()='path' and contains(@d,'M4 16s-1 0')]")
        getWebElement(By.xpath("//*[name()='path' and contains(@d,'M4 16s-1 0')]")).click();
    }



}
