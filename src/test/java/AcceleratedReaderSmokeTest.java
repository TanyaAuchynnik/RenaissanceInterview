import Base.BaseTest;
import Models.ARBookfinderPages.ARBookfinderSearchPage;
import Models.ARBookfinderPages.ARBookfinderBookBagPage;
import Models.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AcceleratedReaderSmokeTest extends BaseTest {
  /**
   * TC for smoke test: User can add books to AR BookBag
   * 1. Navigate to: https://www.renaissance.com/
   * 2. On a dropdown menu Resources chose AR Bookfinder
   * 3. On an opened Accelerated Reader Bookfinder Page chose Parent option
   * 4. On an opened Accelerated Reader Bookfinder Search Page verify that the Parent user is applied
   * 5. For search chose Collection ->What Kids Are Reading->2022->Top 20 Fiction/Nonfiction Books->Grade 11
   * 6. On search results add the book The Adventures of Huckleberry Finn (Unabridged) and book 	Divergent to the AR BookBag
   * 7. Navigate to the AR BookBag
   * 8. Verify that AR BookBag contains 2 books
   */

  @Test
  public void testAddingItemsToARBookBag() {
    ARBookfinderSearchPage newARBookfinderSearchPage = new HomePage(getDriver())
        .navigateToResourcesDropdownMenu(HomePage.class)
        .clickResourcesMenuARBookfinder()
        .choseUserTypeOptions()
        .clickButtonSubmit();

    Assert.assertEquals(newARBookfinderSearchPage.getTextLinkUserType(), "Parent");

    ARBookfinderBookBagPage newBookBagPage = newARBookfinderSearchPage.clickLinkCollections()
        .clickLinkWhatKidsAreReading()
        .clickLink2022()
        .clickLinkTop20FictionNonfictionBooks()
        .clickLinkGrade11()
        .addBookToARBookBag("The Adventures of Huckleberry Finn (Unabridged)")
        .addBookToARBookBag("Divergent")
        .clickButtonARBookBag();

    Assert.assertEquals(newBookBagPage.getBooksCount(), 2);
  }
}
