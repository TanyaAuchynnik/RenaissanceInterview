package Models.ARBookfinderPages;

import Models.BasePages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ARBookfinderSearchPage extends BasePage {
  @FindBy(id = "ctl00_hlUserTypeLink")
  private WebElement linkUserType;

  @FindBy(id = "ctl00_lblCollectionsTabLabel")
  private WebElement linkCollections;

  @FindBy(id = "ctl00_ContentPlaceHolder1_ucCollection_img1823635")
  private WebElement linkWhatKidsAreReading;

  @FindBy(id = "ctl00_ContentPlaceHolder1_ucCollection_lnk4365378")
  private WebElement link2022;

  @FindBy(id = "ctl00_ContentPlaceHolder1_ucCollection_lnk4365379")
  private WebElement linkTop20FictionNonfictionBooks;

  @FindBy(id = "ctl00_ContentPlaceHolder1_ucCollection_list4365382")
  private WebElement linkGrade11;

  @FindBy(xpath = "//*[@title='AR BookBag']")
  private WebElement buttonARBookBag;

  public ARBookfinderSearchPage(WebDriver driver) {
    super(driver);
  }

  public String getTextLinkUserType() {
    return linkUserType.getText();
  }

  public ARBookfinderSearchPage clickLinkCollections() {
    linkCollections.click();
    return this;
  }

  public ARBookfinderSearchPage clickLinkWhatKidsAreReading() {
    linkWhatKidsAreReading.click();
    return this;
  }

  public ARBookfinderSearchPage clickLink2022() {
    link2022.click();
    return this;
  }

  public ARBookfinderSearchPage clickLinkTop20FictionNonfictionBooks() {
    linkTop20FictionNonfictionBooks.click();
    return this;
  }

  public ARBookfinderSearchPage clickLinkGrade11() {
    linkGrade11.click();
    return this;
  }

  public ARBookfinderSearchPage addBookToARBookBag(String bookTitle) {
    getActions().moveToElement(getDriver().findElement(By.xpath(String.format(
            "//a[contains(text(),'%s')]/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*" +
                "/following-sibling::table", bookTitle))))
        .perform();

    getDriver().findElement(By.xpath(String.format(
        "//a[contains(text(),'%s')]/following-sibling::table/tbody/tr/td/input", bookTitle))).click();

    return this;
  }

  public ARBookfinderBookBagPage clickButtonARBookBag() {
    buttonARBookBag.click();
    return new ARBookfinderBookBagPage(getDriver());
  }

}
