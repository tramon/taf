package core.configuration.runtime;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class RuntimeVariablesManager {

  @Getter
  private static String env;
  @Getter
  private static String browser;
  @Getter
  private static String os;
  @Getter
  private static boolean remote;
  @Getter
  private static String browserStackUserName;
  @Getter
  private static String browserStackAccessKey;


  public static void initRuntimeVariables() {
    log.debug("Initializing Runtime variables");

    env = getStringValue(RuntimeVariables.ENV);
    remote = Boolean.parseBoolean(getStringValue(RuntimeVariables.REMOTE));

    if (remote) {
      browserStackUserName = getStringValue(RuntimeVariables.BROWSERSTACK_USERNAME);
      browserStackAccessKey = getStringValue(RuntimeVariables.BROWSERSTACK_ACCESS_KEY);
    }

    os = getStringValue(RuntimeVariables.OS);

    String currentBrowser = getStringValue(RuntimeVariables.BROWSER);

    if (currentBrowser != null) {
      log.debug("Browser: " + currentBrowser);
      browser = currentBrowser;
    } else {
      browser = "chrome";
      log.debug("Browser: Chrome");
    }

  }

  private static String getStringValue(RuntimeVariables runtimeVariables) {
    return System.getProperty(runtimeVariables.getValue());
  }


}
