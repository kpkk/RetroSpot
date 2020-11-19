package com.org;
import com.paulhammant.ngwebdriver.NgWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RetroTests {

    Wrappers wrp=new Wrappers();
    @Test
    public void testLogin(){
        wrp.launchBrowser();
        WebElement username = wrp.locateElemenent("name", "username");
        username.sendKeys("krishnapradeep.kadarla@cognizant.com");
        WebElement password = wrp.locateElemenent("name", "password");
        password.sendKeys("pradeep5");
        WebElement login = wrp.locateElemenent("xpath", "//*[text()='Login']");
        login.click();
       // wrp.tearDown();
    }

    @Test
    public void signUp(){
        wrp.launchBrowser();
        WebElement signupLink = wrp.locateElemenent("xpath", "//a[text()='Signup']");
        signupLink.click();
        WebElement fullname = wrp.locateElemenent("id", "username");
        fullname.sendKeys("user1");
        WebElement email = wrp.locateElemenent("id", "email");
        email.sendKeys("user@email.com");
        WebElement password = wrp.locateElemenent("xpath", "//input[@id='password']");
        password.sendKeys("password");
        WebElement submit = wrp.locateElemenent("xpath", "//button[text()='SignUp']");
        submit.click();

    }

    @Test
    public void createTeam(){
        //wrp.launchBrowser();
        testLogin();
        WebElement createTeam = wrp.locateElemenent("xpath", "//button[text()=' Create Team']");
        createTeam.click();
        WebElement teamName = wrp.locateElemenent("xpath", "//input[@name='teamName']");
        teamName.sendKeys("FirstTeam");
        WebElement createButton = wrp.locateElemenent("xpath", "//button[text()='Create']");
        createButton.click();

    }
}
