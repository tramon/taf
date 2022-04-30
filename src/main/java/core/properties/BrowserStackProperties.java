package core.properties;

import info.macias.kaconf.KA;
import info.macias.kaconf.Property;

public class BrowserStackProperties {

  @Property("browserstack.username")
  public static String BROWSERSTACK_USERNAME = KA.aString();

  @Property("browserstack.access.key")
  public static String BROWSERSTACK_ACCESS_KEY = KA.aString();

}
