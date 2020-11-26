package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.org.Wrappers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;

public class Report {
    public static ExtentHtmlReporter html;
    public static ExtentReports extent;
    public static ExtentTest svcTest;
    public ExtentTest testSuite;
    public String testCaseName, testDescription, authors, category, sheetName;


    public void beginreport() {

        html = new ExtentHtmlReporter("./reports/result.html");
        extent = new ExtentReports();
        extent.attachReporter(html);
        }
    public void startTestCase(){
         testSuite = extent.createTest(testCaseName, testDescription);
         testSuite.assignAuthor(authors);
         testSuite.assignCategory(category);
        // return testSuite;

    }

    public void reportStep(String status, String desc){
        if (status.equalsIgnoreCase("PASS")) {

            testSuite.pass(desc);
        }
        else if(status.equalsIgnoreCase("FAIL")){
            testSuite.fail(desc);
        }
        else if(status.equalsIgnoreCase("INFO")){
            testSuite.warning(desc);
        }
        else {
            testSuite.info(desc);
        }
    }

    public void endResult() {
        extent.flush();
    }

//    public void reportStep(String status, String desc, boolean bn) {
//        long snapNumber = 100000L;
//       MediaEntityModelProvider img=null;
//        try {
//           snapNumber = wrp.takeSnap();
//            img = MediaEntityBuilder.createScreenCaptureFromPath("./../reports/images/" + snapNumber + ".png").build();
//            if (status.equalsIgnoreCase("pass")) {
//                testSuite.pass(desc,img);
//            } else if (status.equalsIgnoreCase("fail")) {
//                testSuite.pass(desc,img);
//            } else if (status.equalsIgnoreCase("warning")) {
//                testSuite.pass(desc,img);
//            } else {
//                testSuite.info(desc);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//

//    }
//    public void reportStep(String desc, String status) {
//        reportStep(desc, status);
//    }


}
