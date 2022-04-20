package steps.google;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static core.properties.Properties.BASE_URL;
import static core.properties.Properties.ENDPOINT_CALC;
import static org.hamcrest.Matchers.is;

import com.codeborne.selenide.Selenide;
import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.google.GoogleCalcPage;

@Slf4j
public class GoogleCalcSteps {

  private GoogleCalcPage googleCalcPage;
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

  public void verifyGoogleCalcPageOpen() {
    waitForGoogleCalcPageLoading();
    MatcherAssert.assertThat("Google calc page is not open",
        googleCalcPage.getMainContent().isDisplayed(), is(true));
  }

  public void verifyGoogleCalcPageIsNotOpen() {
    waitForGoogleCalcPageLoading();
    MatcherAssert.assertThat("Google calc page is open",
        googleCalcPage.getMainContent().isDisplayed(), is(false));
  }

  private void waitForGoogleCalcPageLoading() {
    googleCalcPage = new GoogleCalcPage();
    WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10L));
    wait.until(ExpectedConditions.visibilityOf(googleCalcPage.getMainContent()));
  }

}
