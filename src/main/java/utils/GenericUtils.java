package utils;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GenericUtils {

   private final WebDriver driver;



    public  GenericUtils(WebDriver driver){
        this.driver = driver;
    }


    public void removeAds() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "document.querySelectorAll('iframe, .adsbygoogle, .ad-container, .google-auto-placed').forEach(e => e.remove());"
        );
    }

    public void wait(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}
