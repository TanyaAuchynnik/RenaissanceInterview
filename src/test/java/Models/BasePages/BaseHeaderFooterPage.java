package Models.BasePages;

import Models.ARBookfinderPages.ARBookfinderPage;
import Models.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public abstract class BaseHeaderFooterPage extends BasePage {
  @FindBy(id = "nav-menu-resources")
  private WebElement dropdownResources;

  @FindBy(xpath = "//div[@data-group='tools']/li/a/span[contains(text(),'AR Bookfinder')]")
  private WebElement toolsMenuARBookfinder;

  public BaseHeaderFooterPage(WebDriver driver) {
    super(driver);
  }

  public <T extends BaseHeaderFooterPage> T navigateToResourcesDropdownMenu(Class<T> type) {
    getActions().moveToElement(dropdownResources).perform();
    Constructor<T> cons = null;
    try {
      cons = type.getConstructor(WebDriver.class);
      return cons.newInstance(getDriver());
    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }

  public ARBookfinderPage clickResourcesMenuARBookfinder() {
    toolsMenuARBookfinder.click();

    String parent_window = getDriver().getWindowHandle();
    Set<String> windows = getDriver().getWindowHandles();
    for (String child_window : windows) {
      if (!parent_window.equals(child_window)) {
        getDriver().switchTo().window(child_window);
      }
    }
    return new ARBookfinderPage(getDriver());
  }

}
