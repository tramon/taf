package core.configuration;


import core.configuration.runtime.RuntimeVariablesManager;
import core.configuration.webdriver.WebDriverManager;
import core.properties.PropertiesManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConfigurationManager {

  public static void initializeTestAutomationFramework() {
    log.info("Configuring Test Automation Framework");

    RuntimeVariablesManager.initRuntimeVariables();
    PropertiesManager.initEnvironmentProperties();
    WebDriverManager.initWebDriver();
  }

}
