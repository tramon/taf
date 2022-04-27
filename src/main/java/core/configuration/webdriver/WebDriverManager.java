package core.configuration.webdriver;

import com.codeborne.selenide.Configuration;

import core.configuration.runtime.RuntimeVariablesManager;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;

@Slf4j
public class WebDriverManager {

  private static DesiredCapabilities desiredCapabilities;

  public static void initWebDriver() {
    log.debug("Initialising WebDriver Capabilities Options and RemoteWebdriver configurations");
    setUpDesiredCapabilities();
    setUpRemoteDriver();
  }

  public static void setUpDesiredCapabilities() {
//    desiredCapabilities = new DesiredCapabilities();

//    TODO finish DesiredCapabilities set up

//    DesiredCapabilities caps = new DesiredCapabilities();
//    caps.setCapability("browserName", "iPhone");
//    caps.setCapability("device", "iPhone 11");
//    caps.setCapability("realMobile", "true");
//    caps.setCapability("local", "true");
//    caps.setCapability("os_version", "14.0");
//    caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
//    caps.setCapability("build", "BStack Build Number 1")

//    Configuration.browserCapabilities = desiredCapabilities;

  }

  private static void setUpRemoteDriver() {
    if (RuntimeVariablesManager.isRemote()) {
      Configuration.remote = BrowserStackUrlProvider.getUrl();
      desiredCapabilities.setCapability("browserstack.debug", true);
      desiredCapabilities.setCapability("browserstack.local", false);
      Configuration.browserCapabilities = desiredCapabilities;
    } else {
      log.debug("Remote Mode is false. Using local Mode");
    }

  }

}
