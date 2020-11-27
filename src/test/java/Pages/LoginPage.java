package Pages;

import com.org.Wrappers;
import org.openqa.selenium.WebElement;

public class LoginPage extends Wrappers {

    public WebElement usernameField() {

        WebElement username = locateElemenent("name", "username");
        return username;

    }

    public WebElement passwordField() {

        WebElement password = locateElemenent("name", "password");
        return password;

    }

    public WebElement submitButton() {
        WebElement submit = locateElemenent("xpath", "//*[text()='Login']");
        return submit;
    }


}
