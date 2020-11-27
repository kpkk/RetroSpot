package Pages;

import com.org.Wrappers;
import org.openqa.selenium.WebElement;

public class CreatTeamPage extends Wrappers {

    public WebElement createTeamButton(){

        WebElement createTeam = locateElemenent("xpath", "//button[text()=' Create Team']");
        return createTeam;
    }

    public WebElement teamNameTextBox(){
        WebElement teamName = locateElemenent("xpath", "//input[@name='teamName']");
        return teamName;
    }

    public WebElement createConfirmButton(){
        WebElement createButton = locateElemenent("xpath", "//button[text()='Create']");
        return createButton;
    }
}
