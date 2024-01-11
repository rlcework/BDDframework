package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions( tags ="@LoginFunctionality",
        features = "src/test/java/features",
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-html-report.html"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
