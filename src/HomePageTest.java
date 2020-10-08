import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends TestBase {
    HomePage homePage;


    @BeforeMethod
    public void unitTests(){
        homePage = new HomePage(driver);
    }

    @Test
    public void testHomePageHasATitle(){
        Assert.assertEquals(driver.getTitle(), "Oscar - Sandbox");
    }

    @Test
    public void testHomePageHasALoginLink(){
        Assert.assertTrue(homePage.shouldBeLoginLink());
    }

    @Test
    public void testUserCanChangeLanguage() {
        homePage.selectLanguage("ru");
        homePage.clickOnGoButton();
        Assert.assertTrue(homePage.souldBeRussianText());
    }

    @Test
    public void testUserCanSearchProduct() throws InterruptedException {
        String searchValue = "book";
        homePage.enterTextInSearchField(searchValue);
        homePage.clickOnSearchButton();
        Thread.sleep(5000);
        Assert.assertTrue(homePage.shouldBeSearchList(searchValue));
    }







}
