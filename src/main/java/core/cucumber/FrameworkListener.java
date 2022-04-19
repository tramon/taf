package core.cucumber;

import core.ConfigurationManager;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.Plugin;
import io.cucumber.plugin.event.EventHandler;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunStarted;

public class FrameworkListener implements Plugin, ConcurrentEventListener {

  private final EventHandler<TestRunStarted> setup = e -> ConfigurationManager.loadEnvProperties();

  @Override
  public void  setEventPublisher(final EventPublisher publisher) {
    publisher.registerHandlerFor(TestRunStarted.class, setup);
  }

}
