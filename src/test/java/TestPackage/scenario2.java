package TestPackage;
import BasePage.TestBase;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class scenario2 extends TestBase {
    HomePage homePageObj;
    @Test
    public void OpenTodayDeals() throws InterruptedException {
        homePageObj = new HomePage(driver);
        homePageObj.SwitchToEnglishLang();
        homePageObj.openTodayDealsPage();
        homePageObj.SelectFilters();
        homePageObj.SelectTenPercentDiscount();
        homePageObj.SelectAProductFromTheResultsPage();
        Assert.assertTrue(homePageObj.succfullyAddedToCart.isDisplayed());
    }
}
