package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "pretty",
        tags = "@smoke",
        features = "src/test/resources/features",
        glue = "java/steps/api",
        monochrome = true)

public class RunTest {
}
