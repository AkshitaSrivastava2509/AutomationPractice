package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions( features = "@target/failed_scenarios.txt",
glue={"stepDefinitions","hooks"},
plugin = {"pretty", "html:target/cucumber-report.html","json:target/cucumber-report.json",
         "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",},
         monochrome = true, publish = true)

public class FailedTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
      public Object[][] scenarios() {
        return super.scenarios();
    }
}
