package TestCases;

import Pages.CreatTeamPage;
import Pages.LoginPage;
import com.org.Wrappers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC03_CreateTeam extends CreatTeamPage {

    @BeforeClass
    public void setData() {
        testCaseName = "TC03_CreateTeam";
        testDescription = "This test will create the team in the retrospot application";
        authors = "pradeep";
        category = "smoke";
        sheetName = "TC03_CreateTeam";
    }

    @Test(dataProvider = "fetchdata")
    //@Parameters("TeamName")
    public void createTeam(String template) throws InterruptedException {
        String finalTeamName= "MyTeam"+randomGenerator(5);
        launchBrowser();
        login();
        WebElement teamButton = createTeamButton();
        clickEle(teamButton);
        WebElement teamName = teamNameTextBox();
        enterKeys(finalTeamName,teamName);
        WebElement confirmButton = createConfirmButton();
        clickEle(confirmButton);
        WebElement createdTeam = RetroTeamNameLink(finalTeamName);
        verifyText(createdTeam, finalTeamName);
        clickEle(createdTeam);
        WebElement startRetro = startRetroLink();
        clickEle(startRetro);
        WebElement retroText = enterRetroName();
        enterKeys(finalTeamName,retroText);
        WebElement retroButton = createRetroButton();
        clickEle(retroButton);
        WebElement templates = selectTemplate(template);
        clickEle(templates);
        String[] templateSections = template.trim().split(",");
        for(int i=0;i<templateSections.length;i++){
            findElement("//span[text()='"+templateSections[i].trim()+"']");
        }


    }
}
