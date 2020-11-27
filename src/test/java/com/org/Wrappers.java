package com.org;

import Pages.LoginPage;
import Utils.ReadFromExcel;

import Utils.Report;
import com.paulhammant.ngwebdriver.NgWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Wrappers extends Report {

   public static RemoteWebDriver driver;
    public static NgWebDriver ngdriver;


    @BeforeSuite
    public void beforeSuite(){
        beginreport();
    }

    @BeforeMethod
    public void startTest(){
        startTestCase();

    }


    public void launchBrowser() {

        try{
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            ngdriver=new NgWebDriver(driver);
            driver.get("http://retrospot.s3-website-eu-west-1.amazonaws.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            ngdriver.waitForAngularRequestsToFinish();
            reportStep("PASS","browser has been launched successfully");
        }catch (Exception e){
            reportStep("FAIL","unable to lunch the browser");
        }


    }

    public void login(){
        WebElement username = new LoginPage().usernameField();
        enterKeys("krishnapradeep.kadarla@cognizant.com",username);
        WebElement password = new LoginPage().passwordField();
        enterKeys("pradeep5",password);
        WebElement submit = new LoginPage().submitButton();
        clickEle(submit);
    }
    public WebElement locateElemenent(String locator, String value)  {

        try{
            switch(locator) {
                case "id":
                    return driver.findElementById(value);
                case "class":
                    return driver.findElementByClassName(value);
                case "xpath":
                    return driver.findElementByXPath(value);
                case "linkText":
                    return driver.findElementByLinkText(value);
                case "name":
                    return driver.findElementByName(value);
            }

                reportStep("PASS",locator+" has been identified by its "+ value);
                 takeSnap();



        }catch (Exception e){
            reportStep("FAIL",locator+" has not been found by its "+ value);


        }
        reportStep("PASS",locator+" has been identified by its "+ value);
        try {
            takeSnap();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
    public void takeSnap() throws IOException {
        long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
        FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE),new File("./reports/images/"+number+".png"));

    }

    public void enterKeys(String text, WebElement element) {

        try{
            element.clear();
            element.sendKeys(text);
            reportStep("PASS",text+" has been entered in the text box");
            takeSnap();
        }
        catch (Exception e){
            reportStep("FAIl",text+" hasn't been entered in the text box");
            try {
                takeSnap();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }



    }
    public void clickEle(WebElement element) {

        try{
            element.click();
            reportStep("PASS",element+" has been clicked succesfully");
            takeSnap();
        }catch (Exception e){
            reportStep("FAIL",element+" hasn't been clicked succesfully");
            try {
                takeSnap();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        //endResult();

    }


    @AfterSuite
    public void afterSuite(){
        endResult();
    }
    @DataProvider(name ="fetchdata")
    public Object[][] feedData() throws Exception {
      //  String sheetName = context.getAttribute("sheetName").toString();

        // ReadFromExcel rd=new ReadFromExcel();
        Object[][] testdata = ReadFromExcel.readData(sheetName, "./TestData/Data.xlsx");

        return testdata;

    }
}
