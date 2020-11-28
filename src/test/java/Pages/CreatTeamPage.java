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

    public WebElement RetroTeamNameLink(String teamName){
       // String retro_Teamname= teamName+randomGenerator(5);;
        return locateElemenent("xpath", "//div[text()=' "+teamName+" ']");
    }
    public WebElement getLoggedInUser(String uname) throws InterruptedException {
        Thread.sleep(3000);

        WebElement username = locateElementByxpath("//h4[text()=' " + uname + "']");
       // waitForElement(username);
        return username;
    }
    public WebElement startRetroLink(){
        return locateElemenent("xpath", "//div[text()=' Start your first retro ']");
    }
    public WebElement enterRetroName(){
        return locateElemenent("xpath","//input[@type='text' and @name='sessionname']");
    }
    public WebElement selectTemplate(String template){
        return locateElemenent("xpath","//div[text()='"+template+"']");
    }
    public WebElement createRetroButton(){
       return locateElemenent("xpath", "//button[text()=' Create Retro ']");
    }

}
