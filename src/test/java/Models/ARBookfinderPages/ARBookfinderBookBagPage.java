package Models.ARBookfinderPages;

import Models.BasePages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ARBookfinderBookBagPage extends BasePage {
  @FindBy(id = "book-title")
  private List<WebElement> bookTitles;

  public ARBookfinderBookBagPage(WebDriver driver) {
    super(driver);
  }

  public int getBooksCount() {
    return bookTitles.size();
  }

}
