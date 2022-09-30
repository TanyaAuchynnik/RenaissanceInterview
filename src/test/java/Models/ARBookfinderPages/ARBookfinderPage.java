package Models.ARBookfinderPages;

import Models.BasePages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ARBookfinderPage extends BasePage {
  @FindBy(id = "radParent")
  private WebElement radioParent;

  @FindBy(id = "btnSubmitUserType")
  private WebElement buttonSubmit;

  public ARBookfinderPage(WebDriver driver) {
    super(driver);
  }

  public ARBookfinderPage choseUserTypeOptions() {
    radioParent.click();
    return this;
  }

  public ARBookfinderSearchPage clickButtonSubmit() {
    buttonSubmit.click();
    return new ARBookfinderSearchPage(getDriver());
  }

}
