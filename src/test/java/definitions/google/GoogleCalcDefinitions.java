package definitions.google;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import steps.google.GoogleCalcSteps;

@Slf4j
public class GoogleCalcDefinitions {

  GoogleCalcSteps googleCalcSteps = new GoogleCalcSteps();

  @Given("I open a google calc page")
  public void openMainPage() {
    googleCalcSteps.openMainPage();
  }

  @Given("Log {string} Message")
  public void logMessage(String message) {
    googleCalcSteps.logMessage(message);
  }

  @Then("The Google calc page is open")
  public void verifyGoogleCalcPageOpen() {
    googleCalcSteps.verifyGoogleCalcPageOpen();
  }

  @Then("The Google calc page is not open")
  public void verifyGoogleCalcPageIsNotOpen() {
    googleCalcSteps.verifyGoogleCalcPageIsNotOpen();
  }

}
