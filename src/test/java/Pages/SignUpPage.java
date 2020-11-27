package Pages;

import com.org.Wrappers;
import org.openqa.selenium.WebElement;

public class SignUpPage extends Wrappers {

    public WebElement signUpLinkField(){
        WebElement signupLink = locateElemenent("xpath", "//a[text()='Signup']");
        return signupLink;
    }

    public WebElement fullNameField(){
        WebElement fullname = locateElemenent("id", "username");
        return fullname;

    }

    public WebElement emailField(){
        WebElement email = locateElemenent("id", "email");
        return email;

    }
    public WebElement passwordField(){
        WebElement password = locateElemenent("xpath", "//input[@id='password']");
        return password;
    }

    public WebElement submitForm(){
        WebElement submitbutton = locateElemenent("xpath", "//button[text()='SignUp']");
        return submitbutton;
    }
}
