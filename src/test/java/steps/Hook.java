/****************************************************************************
 Author: Laddu shashavali
 Last updated: 01/20/19
 Description: Initialize the driver with browser using Singleton and
              run specific tag before and after each scenario
 ***************************************************************************/

package steps;

import base.DriverHandler;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Hook{

    private WebDriver driver;
    public Scenario scenario;

    public WebDriver getDriver(){
        return this.driver;
    }

    @Before
    public void InitiliazeTest(Scenario scenario){
        System.out.println("Running Scenario: " + scenario.getName());

        // Here Singleton pattern is being used, to avoid opening a new browser each time a scenario runs
        this.scenario = scenario;
        driver = DriverHandler.GetInstanceDriverHandler().getDriver();
    }

    //this will run after each scenario
    @After
    public void TearDownTest(Scenario scenario){

      /*  if(scenario.isFailed()){
            System.out.println(scenario.getName() + " failed.");
        }*/
        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                // byte[] screenshot = getScreenshotAs(OutputType.BYTES);
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {

            }



        }

        driver.quit();
    }
}
