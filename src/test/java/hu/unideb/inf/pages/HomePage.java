package hu.unideb.inf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Optional;

public class HomePage {

    private static final String PAGE_URL = "http://tutorialsninja.com/demo/";
    @FindBy(css = "#content > div.row > div:nth-child(1) > div > div.button-group > button:nth-child(2)")
    private WebElement wishlistButton;

    @FindBy(css = "#content > div.row > div:nth-child(1) > div > div.button-group > button:nth-child(1)")
    private  WebElement addToCartButton;

    private static final By WISHLIST_ERROR = By.cssSelector("#common-home > div.alert.alert-success.alert-dismissible a");

    private static final By CART_TOTAL = By.id("cart-total");

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }


    public WebElement getField(By locator) {
        return driver.findElement(locator);
    }

    public WebElement getWishlistButton() {
        return wishlistButton;
    }

    public Optional<String> getWishlistError() {
        return getErrorMessage(WISHLIST_ERROR);
    }

    public Optional<String> getCartTotal() {
        return getErrorMessage(CART_TOTAL);
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

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }
}
