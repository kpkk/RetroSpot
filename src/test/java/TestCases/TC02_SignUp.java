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
        testCaseName = "TC02_SignUp";
        testDescription = "Sign up to th Retrospot application";
        authors = "pradeep";
        category = "smoke";
        sheetName = "TC02_SignUp";
    }


    @Test(dataProvider = "fetchdata")
    public void signUp(String fullName, String emailId, String pass) throws IOException {
        launchBrowser();
        String emailpart = emailId + String.valueOf(randomNumber());
        String finalEmail = emailpart+"@mail.com";
        System.out.println(finalEmail);
        WebElement signupLink = signUpLinkField();
        clickEle(signupLink);
        WebElement fullname = fullNameField();
        enterKeys(emailpart, fullname);
        WebElement email = emailField();
        enterKeys(finalEmail, email);
        WebElement password = passwordField();
        enterKeys(pass, password);
        WebElement submit = submitForm();
        clickEle(submit);
        loginWithSpecificUser(finalEmail, pass);
    }
}
