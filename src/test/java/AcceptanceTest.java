import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;


@Slf4j
public class AcceptanceTest {

  @Test
  public void test1() {
    log.info("information");
    Assert.assertTrue( true);
  }

  @Test
  public void test2() {
    Assert.assertTrue( true);
  }

}
