package com.org;

import com.paulhammant.ngwebdriver.NgWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class Wrappers {

   public static RemoteWebDriver driver;
    public static NgWebDriver ngdriver;


    public void launchBrowser(){
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
         ngdriver=new NgWebDriver(driver);
        driver.get("http://retrospot.s3-website-eu-west-1.amazonaws.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        ngdriver.waitForAngularRequestsToFinish();

    }
    public WebElement locateElemenent(String locator, String value){
        switch(locator){
            case "id":return driver.findElementById(value);
            case "class": return driver.findElementByClassName(value);
            case "xpath": return driver.findElementByXPath(value);
            case "linkText": return driver.findElementByLinkText(value);
            case "name": return driver.findElementByName(value);

        }

        return null;
    }

    public void sendKeys(String text, WebElement element){
        element.clear();
        element.sendKeys(text);

    }
    public void click(WebElement element){
        element.click();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();

    }
}
