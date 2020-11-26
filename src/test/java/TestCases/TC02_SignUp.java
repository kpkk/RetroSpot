package TestCases;

import com.org.Wrappers;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC02_SignUp extends Wrappers {

    @BeforeClass
    public void setData() {
        testCaseName="Tc_02-SignupTest";
        testDescription="Sign up to th Retrospot application";
        authors="pradeep";
        category="smoke";
        sheetName="sheet2";
    }


    @Test(dataProvider = "fetchdata")
    public void signUp(String fullName, String emailId, String pass) throws IOException {
        launchBrowser();
        WebElement signupLink = locateElemenent("xpath", "//a[text()='Signup']");
        clickEle(signupLink);
        WebElement fullname = locateElemenent("id", "username");
       // fullname.sendKeys(fullName);
        enterKeys(fullName,fullname);
        WebElement email = locateElemenent("id", "email");
      //  email.sendKeys(emailId);
        enterKeys(emailId,email);
        WebElement password = locateElemenent("xpath", "//input[@id='password']");
       // password.sendKeys(pass);
        enterKeys(pass,password);
        WebElement submit = locateElemenent("xpath", "//button[text()='SignUp']");
        clickEle(submit);

    }

}
