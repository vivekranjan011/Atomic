package testRunner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue ="stepDefs",
        tags = "@smoke",
        plugin = {"pretty"},
        monochrome = true
)
public class TestRunner {
}
