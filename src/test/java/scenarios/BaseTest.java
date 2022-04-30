package scenarios;

import core.configuration.ConfigurationManager;
import io.cucumber.java.BeforeAll;


public class BaseTest {

  public BaseTest() {
    super();
    ConfigurationManager.initializeTestAutomationFramework();
  }

}
