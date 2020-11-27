package TestCases;

import Pages.CreatTeamPage;
import Pages.LoginPage;
import com.org.Wrappers;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC03_CreateTeam extends CreatTeamPage {

    @BeforeClass
    public void setData() {
        testCaseName = "Tc_03-CreateTeam";
        testDescription = "This test will create the team in the retrospot application";
        authors = "pradeep";
        category = "smoke";
        sheetName = "sheet2";
    }

    @Test
    @Parameters("TeamName")
    public void createTeam(String NameOfTeam) throws InterruptedException {
        launchBrowser();
        login();
        WebElement teamButton = createTeamButton();
        teamButton.click();
        WebElement teamName = teamNameTextBox();
        teamName.sendKeys(NameOfTeam);
        WebElement confirmButton = createConfirmButton();
        confirmButton.click();


    }
}
