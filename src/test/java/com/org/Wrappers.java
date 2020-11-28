package com.org;

import Pages.LoginPage;
import Utils.ReadFromExcel;

import Utils.Report;
import com.paulhammant.ngwebdriver.NgWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Wrappers extends Report {

    public static RemoteWebDriver driver;
    public static NgWebDriver ngdriver;
    public static WebDriverWait wait;


    @BeforeSuite
    public void beforeSuite() {
        beginreport();
    }

    @BeforeMethod
    public void startTest() {
        startTestCase();

    }


    public void launchBrowser() {

        try {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            ngdriver = new NgWebDriver(driver);
            driver.get("http://retrospot.s3-website-eu-west-1.amazonaws.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            ngdriver.waitForAngularRequestsToFinish();
            reportStep("PASS", "browser has been launched successfully");
        } catch (Exception e) {
            reportStep("FAIL", "unable to lunch the browser");
        }


    }

    public void login() {
        WebElement username = new LoginPage().usernameField();
        enterKeys("krishnapradeep.kadarla@cognizant.com", username);
        WebElement password = new LoginPage().passwordField();
        enterKeys("pradeep5", password);
        WebElement submit = new LoginPage().submitButton();
        clickEle(submit);
    }
    public void loginWithSpecificUser(String user, String passcode) {
        WebElement username = new LoginPage().usernameField();
        enterKeys(user, username);
        WebElement password = new LoginPage().passwordField();
        enterKeys(passcode, password);
        WebElement submit = new LoginPage().submitButton();
        clickEle(submit);
    }

    public WebElement locateElemenent(String locator, String value) {

        try {
            switch (locator) {
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

                default:
                    Assert.fail("Webelement has not been found");
                    reportStep("FAIL", locator + " has not been found by its " + value);

            }


            reportStep("PASS", locator + " has been identified by its " + value);
            // takeSnap();


        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            reportStep("FAIL", locator + " has not been found by its " + value);


        }
        reportStep("PASS", locator + " has been identified by its " + value);
        try {
            takeSnap();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    public void takeSnap() throws IOException {
        long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
        FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File("./reports/images/" + number + ".png"));

    }

    public void enterKeys(String text, WebElement element) {

        try {
            element.clear();
            element.sendKeys(text);
            reportStep("PASS", text + " has been entered in the text box");
            takeSnap();
        } catch (Exception e) {
            reportStep("FAIl", text + " hasn't been entered in the text box");
            try {
                takeSnap();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


    }

    public void clickEle(WebElement element) {

        try {
            element.click();
            reportStep("PASS", element + " has been clicked succesfully");
            takeSnap();
        } catch (Exception e) {
            reportStep("FAIL", element + " hasn't been clicked succesfully");
            try {
                takeSnap();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    public String randomGenerator(int count) {
        return RandomStringUtils.randomAlphabetic(count);
    }

    public void verifyText(WebElement ele, String text) {

        String element_text = ele.getText();
        if (element_text.equalsIgnoreCase(text)) {
            reportStep("PASS", "the webElement text is matching with the given text");
        } else {
            Assert.assertEquals(element_text, text);
            reportStep("FAIL", "the text of the web element" + element_text + "  and given text" + text + " are not matched");
        }
    }

    public void waitForElement(WebElement ele) {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public WebElement locateElementByxpath(String xpath) {
        //  WebElement element;
        try {
            return driver.findElementByXPath(xpath);
            //reportStep("PASS", "Element found using xpath");
        } catch (Exception e) {
            reportStep("FAIL", "element not found ");
            Assert.fail("Element not found");
        }
        return null;
    }

    public void scrollBy() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.ScrollBy(0,100)");

    }

    public void scrollIntoElement(WebElement element) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);

    }

    public void dragAndDrop(WebElement source, WebElement dest) {
        Actions act = new Actions(driver);
        act.dragAndDrop(source, dest).build().perform();
    }

    public int randomNumber() {
        return new Random().nextInt(1000);
    }
    public String readFromProperties(String propName){
        Properties pop=new Properties();
        String property="";
        try {
            pop.load(new FileInputStream(new File("./config.propeties")));
            property = pop.getProperty(propName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }

    public void findElement(String xpath){
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        if(elements.size()>0){
            reportStep("PASS","element present on the webpage");
        }else{
            reportStep("FAIL","no elements found for the given xpath");
            Assert.fail("FAILED...element not found");
        }
    }


    @AfterMethod
    public void tearDown() {
        driver.close();
        //endResult();

    }


    @AfterSuite
    public void afterSuite() {
        endResult();
    }

    @DataProvider(name = "fetchdata")
    public Object[][] feedData() throws Exception {
        //  String sheetName = context.getAttribute("sheetName").toString();

        // ReadFromExcel rd=new ReadFromExcel();
        Object[][] testdata = ReadFromExcel.readData(sheetName, "./TestData/Data.xlsx");

        return testdata;

    }
}
