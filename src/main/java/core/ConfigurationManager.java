package core;

import static info.macias.kaconf.sources.JavaUtilPropertySource.from;

import com.google.common.base.Preconditions;
import core.properties.Properties;
import info.macias.kaconf.Configurator;
import info.macias.kaconf.ConfiguratorBuilder;
import java.io.File;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConfigurationManager {

  private static final String ENV_PROPERTY = "env";
  private static final String PATH_TO_PROPERTIES = "src/main/resources/environments/";
  private static final String PATH_TO_PROPERTIES_MASK = "%s.properties";
  private static final String PATH_TO_ENVIRONMENTS_MASK =
      PATH_TO_PROPERTIES + PATH_TO_PROPERTIES_MASK;
  private static final String ERROR_MESSAGE_CONFIGURATION =
      "The following config file does not exist: ";


  public static void loadEnvProperties() {
    log.info("Loading Environment variables");

    String urlProperties = System.getProperty(ENV_PROPERTY);

    File mainConfigFile = new File(String.format(PATH_TO_ENVIRONMENTS_MASK, urlProperties));
    Preconditions.checkArgument(mainConfigFile.exists(),
        ERROR_MESSAGE_CONFIGURATION + mainConfigFile.getAbsolutePath());

    Configurator configurator = new ConfiguratorBuilder().addSource(from(mainConfigFile)).build();
    configurator.configure(Properties.class);
  }

}
