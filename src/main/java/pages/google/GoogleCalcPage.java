package pages.google;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

@Getter
public class GoogleCalcPage extends BasePage {

  @FindBy(xpath = "//div[contains(@class, 'tyYmIf')]")
  private WebElement mainContent;

}
