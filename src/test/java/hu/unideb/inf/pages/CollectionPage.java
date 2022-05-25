package hu.unideb.inf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Optional;

public class CollectionPage {

    private static final String PAGE_URL = "http://tutorialsninja.com/demo/index.php?route=product/category&path=18";

    @FindBy(css = "#content > div:nth-child(7) > div:nth-child(1) > div > div:nth-child(2) > div.button-group > button:nth-child(2)")
    private WebElement wishlistButton;

    @FindBy(css = "#content > div:nth-child(7) > div:nth-child(1) > div > div:nth-child(2) > div.button-group > button:nth-child(3)")
    private WebElement compareButton;

    @FindBy(css = "#content > div:nth-child(5) > div > ul > li:nth-child(1) > a")
    private WebElement categoryButton;

    @FindBy(css = "#content > p")
    private WebElement emptyMessage;

    @FindBy(name = "GBP")
    private WebElement GBPCurrencySelector;

    @FindBy(css = "#form-currency > div > button")
    private WebElement currencySelector;

    @FindBy(css = "#content > div:nth-child(7) > div:nth-child(1) > div > div:nth-child(2) > div.caption > p.price")
    private WebElement productPrice;

    @FindBy(css = "#product-category > div.alert.alert-success.alert-dismissible")
    private WebElement alertMessage;

    private final WebDriver driver;

    public CollectionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }


    public WebElement getField(By locator) {
        return driver.findElement(locator);
    }

    private Optional<String> getErrorMessage(By errorLocator) {
        Optional<WebElement> error = getError(errorLocator);
        if (error.isPresent()) {
            WebElement errorElement = error.get();
            return Optional.of(errorElement.getText());
        } else {
            return Optional.empty();
        }
    }

    private Optional<WebElement> getError(By errorLocator) {
        List<WebElement> elements = driver.findElements(errorLocator);
        if (elements.size() > 0) {
            return Optional.of(elements.get(0));
        } else {
            return Optional.empty();
        }
    }

    public WebElement getWishlistButton() {
        return wishlistButton;
    }

    public WebElement getAlertMessage() {
        return alertMessage;
    }

    public WebElement getCompareButton() {
        return compareButton;
    }

    public WebElement getCategoryButton() {
        return categoryButton;
    }

    public WebElement getEmptyMessage() {
        return emptyMessage;
    }

    public WebElement getCurrencySelector() {
        return currencySelector;
    }

    public WebElement getProductPrice() {
        return productPrice;
    }

    public WebElement getGBPCurrencySelector() {
        return GBPCurrencySelector;
    }
}
