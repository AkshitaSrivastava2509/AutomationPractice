package utils;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import pages.PageObjectManager;

public class TextContextSetup {

    WebDriver driver;
    public PageObjectManager pageObjectManager;
    GenericUtils genericUtils;

    public TextContextSetup(){
        this.driver = DriverFactory.getDriver();
        genericUtils = new GenericUtils(driver);
        pageObjectManager = new PageObjectManager(driver,genericUtils);


    }


}
