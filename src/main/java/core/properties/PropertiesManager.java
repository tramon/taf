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

    File mainConfigFile = new File(String.format(PATH_TO_ENVIRONMENTS_MASK, urlProperties));
    Preconditions.checkArgument(mainConfigFile.exists(),
        "The following config file does not exist: " + mainConfigFile.getAbsolutePath());

    Configurator configurator = new ConfiguratorBuilder().addSource(from(mainConfigFile)).build();
    configurator.configure(Urls.class);
  }

}
