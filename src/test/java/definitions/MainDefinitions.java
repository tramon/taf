package definitions;


import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;
import steps.MainSteps;

@Slf4j
public class MainDefinitions {

  @Given("I open a google calc page")
  public void openMainPage() {
    new MainSteps().openMainPage();
  }

  @Given("Log {string} Message")
  public void logMessage(String message) {
    new MainSteps().logMessage(message);
  }

}
