package TestCases;

import Pages.LoginPage;
import com.org.Wrappers;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC01_LoginTest extends LoginPage {

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
        WebElement user = usernameField();
        enterKeys(uname,user);
        WebElement password = passwordField();
        enterKeys(pass,password);
        WebElement submit = submitButton();
      //  WebElement login = locateElemenent("xpath", "//*[text()='Login']");
        clickEle(submit);
        // wrp.tearDown();
    }
}
