package Models.BasePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
  private WebDriver driver;
  private Actions actions;

  protected WebDriver getDriver() {
    return driver;
  }

  public BasePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  protected Actions getActions() {
    if (actions == null) {
      actions = new Actions(driver);
    }
    return actions;
  }

}
