package steps;

import static core.properties.Properties.BASE_URL;
import static core.properties.Properties.ENDPOINT_CALC;

import com.codeborne.selenide.Selenide;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainSteps {

  public void openMainPage() {
    log.info("Opening Google calc: " + BASE_URL + ENDPOINT_CALC);
    Selenide.open(BASE_URL + ENDPOINT_CALC);
  }

  public void logMessage(String message) {
    log.info("Logging message: " + message);
  }

  public void testNgSmokeTest() {
    log.info("Running testNg Smoke test from scenarios");
  }

}
