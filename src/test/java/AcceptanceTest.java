import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
    features = "src/test/resources/features",
    snippets = SnippetType.CAMELCASE,
    plugin = { "json:build/cucumber/cucumber-report.json", "core.cucumber.CucumberListenerPlugin"}
)
public class AcceptanceTest extends AbstractTestNGCucumberTests {
}
