package scenarios;


import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import steps.MainSteps;

@Slf4j
public class SmokeTest {

  @Test(description = "TestNg Smoke Test from the /scenarios package")
  public void testNg1() {
    new MainSteps().testNgSmokeTest();
  }

}
