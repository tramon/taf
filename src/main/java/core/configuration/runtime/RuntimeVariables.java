package core.configuration.runtime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
enum RuntimeVariables {

  ENV("env"),
  BROWSER("browser"),
  REMOTE("remote"),
  OS("os");

  @Getter
  private final String value;

}
