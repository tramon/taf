package core.properties;

import info.macias.kaconf.KA;
import info.macias.kaconf.Property;

public class Properties {

  @Property("base.url")
  public static String BASE_URL = KA.aString();

  @Property("endpoint.calc")
  public static String ENDPOINT_CALC = KA.aString();

}
