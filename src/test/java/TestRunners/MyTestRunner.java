package TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/com/features"},
        glue = {"stepDefinitions","src/main/java/com/AppHooks"},
        plugin = {"pretty"}
)

public class MyTestRunner {

}
