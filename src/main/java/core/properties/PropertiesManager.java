package core.properties;


import static info.macias.kaconf.sources.JavaUtilPropertySource.from;


import com.google.common.base.Preconditions;


import core.configuration.runtime.RuntimeVariablesManager;
import info.macias.kaconf.Configurator;
import info.macias.kaconf.ConfiguratorBuilder;
import java.io.File;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PropertiesManager {

  private static final String PATH_TO_PROPERTIES = "src/main/resources/environments/";
  private static final String PATH_TO_ENVIRONMENTS_MASK = PATH_TO_PROPERTIES + "%s.properties";

  public static void initEnvironmentProperties() {
    log.debug("Initializing Environment variables and Selenide default Configuration");
    String urlProperties = RuntimeVariablesManager.getEnv();

    File environmentConfigFile = new File(String.format(PATH_TO_ENVIRONMENTS_MASK, urlProperties));
    File browserStackConfigFile = new File("browserstack.properties");

    Preconditions.checkArgument(environmentConfigFile.exists(),
        "The Environment config file does not exist: " +
            environmentConfigFile.getAbsolutePath());
    Preconditions.checkArgument(browserStackConfigFile.exists(),
        "The Browser Stack config file does not exist: " +
            browserStackConfigFile.getAbsolutePath());

    Configurator configurator = new ConfiguratorBuilder()
        .addSource(from(environmentConfigFile))
        .addSource(from(browserStackConfigFile))
        .build();
    configurator.configure(Urls.class);
    configurator.configure(BrowserStackProperties.class);

  }

}
