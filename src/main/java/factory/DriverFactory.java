package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    public WebDriver driver;


    public static  ThreadLocal<WebDriver> threadLocal  = new ThreadLocal<WebDriver>();

    public static WebDriver  init_driver(String browser) {

        System.out.println("browser value is : " + browser);

            if (browser.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                threadLocal.set(new ChromeDriver());
            } else if (browser.equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                threadLocal.set(new FirefoxDriver());
            } else if (browser.equals("edge")) {
                WebDriverManager.edgedriver().setup();
                threadLocal.set(new EdgeDriver());
            } else {
                System.out.println("Please pass the correct browser name: " + browser);
            }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();

        return getDriver();

    }

    public static synchronized WebDriver getDriver(){
        return threadLocal.get();

    }
}
