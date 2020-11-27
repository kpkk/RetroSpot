package TestCases;

import Pages.SignUpPage;
import com.org.Wrappers;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC02_SignUp extends SignUpPage {

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
        WebElement signupLink = signUpLinkField();
        clickEle(signupLink);
        WebElement fullname = fullNameField();
        enterKeys(fullName,fullname);
        WebElement email = emailField();
        enterKeys(emailId,email);
        WebElement password = passwordField();
        enterKeys(pass,password);
        WebElement submit = submitForm();
        clickEle(submit);

    }

}
