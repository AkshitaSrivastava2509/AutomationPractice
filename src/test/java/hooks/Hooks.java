package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Hooks {

    private WebDriver driver;
    ConfigReader configReader;
    Properties prop;


    @Before(order = 0)
    public  void getProperty(){
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(order = 1)
    public void  launchBrowser(){
        String browserName = prop.getProperty("browser");
        driver = DriverFactory.init_driver(browserName);
        driver.get(prop.getProperty("qaUrl"));
    }

    @After(order = 0)
    public void quitBrowser(){
        driver.quit();
    }

    @After(order=1)
    public void tearDown(Scenario scenario) throws IOException {

        if (scenario.isFailed()) {
            //take screenshot
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent,"image/png",screenshotName);
        }
    }
}
