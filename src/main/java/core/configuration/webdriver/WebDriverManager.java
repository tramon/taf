package core.configuration.webdriver;

import com.codeborne.selenide.Configuration;

import core.configuration.runtime.RuntimeVariablesManager;

import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

@Slf4j
public class WebDriverManager {

  private static DesiredCapabilities desiredCapabilities;

  public static void initWebDriver() {
    log.debug("Initialising WebDriver Capabilities Options and RemoteWebdriver configurations");
    setUpDesiredCapabilities();
    setUpBrowser();
    setUpOs();

  }

  private static void setUpOs() {
    if (RuntimeVariablesManager.getOs().equals("iPhone")) {
      setUpIphone();
    } else {
      log.debug("Skipping Iphone setup");
    }

    if (RuntimeVariablesManager.getOs().equals("Android")) {
      setUpAndroid();
    } else {
      log.debug("Skipping Android setup");
    }

  }

  private static void setUpBrowser() {
    Configuration.browser = RuntimeVariablesManager.getBrowser();
    Configuration.browserVersion = "latest";

    setChromeOptionsIfNeeded();
    setUpRemoteDriverIfRemote();
  }

  public static void setUpDesiredCapabilities() {

    log.debug("Setting up Desired Capabilities");
    desiredCapabilities = new DesiredCapabilities();

    desiredCapabilities.setCapability("browserVersion", "latest");
    desiredCapabilities.setCapability("enableVNC", "true");
    desiredCapabilities.setCapability("enableVideo", "false");
    desiredCapabilities.setCapability("FORCE_CREATE_PROCESS", "true");
    desiredCapabilities.setCapability("unhandledPromptBehavior", "accept");
    desiredCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
    desiredCapabilities.setCapability("ignoreProtectedModeSettings", "true");
    desiredCapabilities.setCapability("handlesAlerts", "true");
    desiredCapabilities.setCapability("browserFocus", "false");
    desiredCapabilities.setCapability("ignoreZoomSetting", "true");
    desiredCapabilities.setCapability("nativeEvents", "true");
    desiredCapabilities.setCapability("requireWindowFocus", "true");
    desiredCapabilities.setCapability(
        "INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS", "true");
    desiredCapabilities.setCapability("ACCEPT_SSL_CERTS", "true");

    desiredCapabilities.setCapability("language", "en");
    desiredCapabilities.setCapability("locale", "en_US");
    desiredCapabilities.setCapability("browserstack.safari.allowAllCookies", "true");

    Configuration.browserCapabilities = desiredCapabilities;
  }

  private static void setChromeOptionsIfNeeded() {

    if (RuntimeVariablesManager.getBrowser().equals("chrome")) {
      log.debug("Setting up Chrome Options");

      HashMap<String, Object> prefs = new HashMap<>();
      prefs.put("profile.default_content_settings.cookies", 2);
      prefs.put("profile.default_content_setting_values.cookies", 2);

      ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.addArguments("start-maximized");
      chromeOptions.addArguments("disable-infobars");
      chromeOptions.addArguments("no-first-run");
      chromeOptions.addArguments("homepage=about:blank");
      chromeOptions.addArguments("disable-plugins");
      chromeOptions.addArguments("disable-extensions");
      chromeOptions.addArguments("--ignore-certificate-errors");
      chromeOptions.addArguments("no-default-browser-check");
      chromeOptions.addArguments("--start-fullscreen");
      chromeOptions.addArguments("--disable-gpu");
      chromeOptions.setExperimentalOption("w3c", Boolean.TRUE);
      chromeOptions.setExperimentalOption("prefs", prefs);

      desiredCapabilities.setCapability("browserName", "Chrome");
      desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

      Configuration.browserCapabilities = desiredCapabilities;
    } else {
      log.debug("Skipping Chrome browser setup");
    }

  }

  private static void setUpRemoteDriverIfRemote() {

    if (RuntimeVariablesManager.isRemote()) {
      log.debug("Setting up Remote Driver");
      HashMap<String, Object> browserstackOptions = new HashMap<>();
      browserstackOptions.put("os", "Windows");
      browserstackOptions.put("osVersion", "10");

      desiredCapabilities.setCapability("browserstack.debug", "true");
      desiredCapabilities.setCapability("browserstack.console", "info");
      desiredCapabilities.setCapability("browserstack.networkLogs", "true");
      desiredCapabilities.setCapability("browserstack.local", false);

      desiredCapabilities.setCapability("bstack:options", browserstackOptions);

      Configuration.remote = BrowserStackUrlProvider.getUrl();
      log.debug("selenide.remote=" + BrowserStackUrlProvider.getUrl());

      Configuration.browserCapabilities = desiredCapabilities;
    } else {
      log.debug("Using local Mode");
    }

  }

  private static void setUpIphone() {
      log.debug("Setting up Iphone options and capabilities");
      desiredCapabilities.setCapability("browserName", "iPhone");
      desiredCapabilities.setCapability("device", "iPhone 11");
      desiredCapabilities.setCapability("realMobile", "true");
      desiredCapabilities.setCapability("local", "true");
      desiredCapabilities.setCapability("os_version", "14.0");
      desiredCapabilities.setCapability("name", "BStack-java Test");
      desiredCapabilities.setCapability("build", "BStack Build 1");
      Configuration.browserCapabilities = desiredCapabilities;
  }

  private static void setUpAndroid() {
      log.debug("Setting up Android options and capabilities");
      DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("os_version", "10.0");
      caps.setCapability("device", "Samsung Galaxy S20");
      caps.setCapability("real_mobile", "true");
      caps.setCapability("browserstack.local", "false");
      caps.setCapability("browserstack.debug", "true");
      caps.setCapability("browserstack.networkLogs", "true");
      caps.setCapability("deviceOrientation", "portrait");
      caps.setCapability("browserstack.console", "info");
      caps.setCapability("browser", "chrome");
      Configuration.browserCapabilities = desiredCapabilities;
  }

}
