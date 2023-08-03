package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }
    WebElement searchInput;
    WebElement product;
    List<WebElement> lang;
    List<WebElement> englishLang;
    WebElement saveChangesBtn;
    By addToCart = By.id("add-to-cart-button");
    public WebElement succfullyAddedToCart;
    public String productTitle;
    public WebElement noResFound;
    WebElement todayDeals;
    WebElement groceryCheckBox;
    WebElement electronicsCheckBox;
    WebElement tenPercentDiscount;
    WebElement productInTodayDeals;
    String productInCart = "//span[contains(text(),'@var')]";
    WebElement cart;
    public WebElement productInCartTxt;
    By firstSearchRes = By.xpath("//*[@id=\"grid-main-container\"]/div[3]/div/div[1]/div/div/a/div/div/img");
    Duration duration = Duration.ofSeconds(10);

    public void SwitchToEnglishLang() {
        lang  = driver.findElements(By.className("nav-line-2"));
        lang.get(1).click();
        englishLang = driver.findElements(By.className("a-icon-radio"));
        englishLang.get(1).click();
        saveChangesBtn = driver.findElement(By.className("a-button-input"));
        saveChangesBtn.click();
        WebDriverWait wait = new WebDriverWait(driver,duration);
    }
    public void SearchForAKeyWord(String keyword) {
        searchInput = driver.findElement(By.id("twotabsearchtextbox"));
        searchInput.sendKeys(keyword);
        searchInput.sendKeys(Keys.RETURN);
        WebDriverWait wait = new WebDriverWait(driver,duration);
    }
    public void SelectFirstItem(){
        product = driver.findElement(By.className("a-price-whole"));
        product.click();
        productTitle = driver.findElement(By.id("productTitle")).getText();
        WebDriverWait wait = new WebDriverWait(driver,duration);
    }
    public void AddItemToCart() {
        driver.findElement(addToCart).click();
        succfullyAddedToCart = driver.findElement(By.id("NATC_SMART_WAGON_CONF_MSG_SUCCESS"));
        WebDriverWait wait = new WebDriverWait(driver,duration);
    }
    public void SearchWithInvalidData(){
        noResFound = driver.findElement(By.id("search"));
        WebDriverWait wait = new WebDriverWait(driver,duration);
    }
    public void openTodayDealsPage(){
        todayDeals = driver.findElement(By.linkText("Today's Deals"));
        todayDeals.click();
        WebDriverWait wait = new WebDriverWait(driver,duration);
    }
    public void openCartPage(){
        cart = driver.findElement(By.id("nav-cart"));
        cart.click();
        WebDriverWait wait = new WebDriverWait(driver,duration);
    }
    public void cartIsNotEmpty(){
        productInCart = productInCart.replace("@var",productTitle);
        productInCartTxt = driver.findElement(By.xpath(productInCart));
        System.out.println("true");
        WebDriverWait wait = new WebDriverWait(driver,duration);
    }
    public void SelectFilters(){
        groceryCheckBox = driver.findElement(By.xpath("//*[@id=\"grid-main-container\"]/div[2]/span[3]/ul/li[12]/label"));
        groceryCheckBox.click();
        electronicsCheckBox = driver.findElement(By.xpath("//*[@id=\"grid-main-container\"]/div[2]/span[3]/ul/li[7]/label"));
        electronicsCheckBox.click();
        WebDriverWait wait = new WebDriverWait(driver,duration);
    }
    public void SelectTenPercentDiscount(){
        tenPercentDiscount = driver.findElement(By.linkText("10% off or more"));
        tenPercentDiscount.click();
        WebDriverWait wait = new WebDriverWait(driver,duration);
    }
    public void SelectAProductFromTheResultsPage() throws InterruptedException {
        driver.findElement(firstSearchRes).click();
        productInTodayDeals = driver.findElement(By.xpath("//*[@id=\"octopus-dlp-asin-stream\"]/ul/li[1]/span/div/div[1]"));
        productInTodayDeals.click();
        driver.findElement(addToCart).click();
        succfullyAddedToCart = driver.findElement(By.id("NATC_SMART_WAGON_CONF_MSG_SUCCESS"));
        WebDriverWait wait = new WebDriverWait(driver,duration);
    }
}
