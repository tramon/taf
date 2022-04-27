package core.cucumber;

import core.configuration.ConfigurationManager;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.Plugin;
import io.cucumber.plugin.event.EventHandler;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunStarted;

/**
 *
 * This is a custom plugin that makes all pre-requisite initializations
 * like Properties Runtime Variables and WebDriver Capabilities initialization
 * prior to the start of a feature file execution
 *
 */
public class CucumberListenerPlugin implements Plugin, ConcurrentEventListener {

  private final EventHandler<TestRunStarted> setup =
      e -> ConfigurationManager.initializeTestAutomationFramework();

  @Override
  public void setEventPublisher(final EventPublisher publisher) {
    publisher.registerHandlerFor(TestRunStarted.class, setup);
  }

}
