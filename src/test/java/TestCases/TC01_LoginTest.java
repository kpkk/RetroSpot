package TestCases;

import Pages.CreatTeamPage;
import Pages.LoginPage;
import com.org.Wrappers;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC01_LoginTest extends LoginPage {

    @BeforeClass
    public void setData() {
        testCaseName="TC01_LoginTest";
        testDescription="Login to the RetroSpot application";
        authors="pradeep";
        category="smoke";
        sheetName="TC01_LoginTest";
    }

    @Test( dataProvider="fetchdata")
    public void testLogin(String uname, String pass,String username) throws IOException, InterruptedException {
        launchBrowser();
        WebElement user = usernameField();
        enterKeys(uname,user);
        WebElement password = passwordField();
        enterKeys(pass,password);
        WebElement submit = submitButton();
        clickEle(submit);
        WebElement loggedInuserText = new CreatTeamPage().getLoggedInUser(username);
        verifyText(loggedInuserText,username);


    }
}
