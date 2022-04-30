package scenarios;


import static com.codeborne.selenide.Selenide.$;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.title;
import static core.properties.Urls.BASE_URL;
import static core.properties.Urls.ENDPOINT_CALC;
import static org.hamcrest.Matchers.matchesPattern;

import com.codeborne.selenide.Selenide;

import lombok.extern.slf4j.Slf4j;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import steps.google.GoogleCalcSteps;

@Slf4j
public class SmokeTest extends BaseTest {

  @Test(description = "TestNg Smoke Test from the /scenarios package")
  public void testNg1() {
    new GoogleCalcSteps().testNgSmokeTest();
  }

  @Test
  public void testNg2() {
    Selenide.open(BASE_URL + ENDPOINT_CALC);
    $(By.name("q")).setValue("BrowserStack").pressEnter();

    sleep(1000);
    MatcherAssert.assertThat("Google search does not match the pattern",
        title(), matchesPattern("BrowserStack -.*"));
  }

}
