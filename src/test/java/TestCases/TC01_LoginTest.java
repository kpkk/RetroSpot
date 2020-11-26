package TestCases;

import com.org.Wrappers;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC01_LoginTest extends Wrappers {

    @BeforeClass
    public void setData() {
        testCaseName="Tc_01-LoginTest";
        testDescription="Login to the RetroSpot application";
        authors="pradeep";
        category="smoke";
        sheetName="sheet1";
    }

    @Test( dataProvider="fetchdata")
    public void testLogin(String uname, String pass) throws IOException {
        launchBrowser();
        WebElement username = locateElemenent("name", "username");
       // username.sendKeys(uname);
        enterKeys(uname,username);
        WebElement password = locateElemenent("name", "password");
        password.sendKeys(pass);
        enterKeys(pass,password);
        WebElement login = locateElemenent("xpath", "//*[text()='Login']");
        clickEle(login);
        // wrp.tearDown();
    }
}
