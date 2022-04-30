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
  private static boolean isRemote;

  public static void initRuntimeVariables() {
    log.debug("Initializing Runtime variables");

    initEnv();
    initBrowser();
    initRemote();
    initOs();

  }

  private static void initBrowser() {
    String currentBrowser = getStringValue(RuntimeVariables.BROWSER);

    if (currentBrowser != null) {
      log.debug("Browser: \t\t\t" + currentBrowser);
      browser = currentBrowser;
    } else {
      browser = "chrome";
      log.debug("Using default browser: \t\t\t\tchrome");
    }
  }

  private static void initEnv() {
    env = getStringValue(RuntimeVariables.ENV);
    log.debug("Initializing environment env: \t" + env);
  }

  private static void initOs() {
    os = getStringValue(RuntimeVariables.OS);
    log.debug("Initializing Os: \t\t\t\t\t\t\t" + os);
  }

  private static void initRemote() {
    isRemote = Boolean.parseBoolean(getStringValue(RuntimeVariables.REMOTE));
    log.debug("Initializing Remote work: \t\t\t" + isRemote);
  }

  private static String getStringValue(RuntimeVariables runtimeVariables) {
    return System.getProperty(runtimeVariables.getValue());
  }

}
