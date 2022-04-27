package core.configuration.runtime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
enum RuntimeVariables {

  ENV("env"),
  BROWSER("selenide.browser"),
  REMOTE("selenide.remote"),
  OS("os"),
  BROWSERSTACK_USERNAME("BROWSERSTACK_USERNAME"),
  BROWSERSTACK_ACCESS_KEY("BROWSERSTACK_ACCESS_KEY");

  @Getter
  private final String value;

}
