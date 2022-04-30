package core.configuration.webdriver;


import static core.properties.BrowserStackProperties.BROWSERSTACK_ACCESS_KEY;
import static core.properties.BrowserStackProperties.BROWSERSTACK_USERNAME;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BrowserStackUrlProvider {

  private static final String REMOTE_URL_MASK = "https://%s:%s@hub-cloud.browserstack.com/wd/hub";

  public static String getUrl() {
    return String.format(REMOTE_URL_MASK, BROWSERSTACK_USERNAME, BROWSERSTACK_ACCESS_KEY);
  }

}
