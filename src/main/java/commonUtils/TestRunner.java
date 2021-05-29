package commonUtils;


import java.io.File;

import org.testng.annotations.AfterSuite;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * @author kumar
 * Cucumber Runner class
 *
 */

@CucumberOptions(
        features = "src/test/resource/Features",
        glue = {"com.dive.stepDefinitions"},dryRun = false, strict = false,
        tags = {"@dive_Assignment"},plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"})


public class TestRunner extends AbstractTestNGCucumberTests  {


    @AfterSuite
    public static void setup()
    {
    Reporter.loadXMLConfig(new File("src/test/resource/extent-config.xml"));
    Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
    Reporter.setSystemInfo("Application Name", "dive");
    Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
    Reporter.setSystemInfo("Environment", "QA");
    Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
    }
    
}