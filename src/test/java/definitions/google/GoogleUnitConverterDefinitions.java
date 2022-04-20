package definitions.google;


import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import steps.google.GoogleUnitConverterSteps;

@Slf4j
public class GoogleUnitConverterDefinitions {

  private final GoogleUnitConverterSteps googleUnitConverterSteps = new GoogleUnitConverterSteps();

  @Then("The Google Unit Converter page is open")
  public void verifyUnitConverterOpen() {
    googleUnitConverterSteps.verifyUnitConverterOpen();
  }

}
