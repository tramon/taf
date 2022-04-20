package steps.google;

import static org.hamcrest.Matchers.is;

import lombok.extern.slf4j.Slf4j;
import org.hamcrest.MatcherAssert;
import pages.google.GoogleCalcPage;
import pages.google.GoogleUnitConverterPage;

@Slf4j
public class GoogleUnitConverterSteps {

  public void verifyUnitConverterOpen() {
    MatcherAssert.assertThat("Google unit converted page is not open",
        new GoogleUnitConverterPage().getMainContent().isDisplayed(), is(true));
  }

}
