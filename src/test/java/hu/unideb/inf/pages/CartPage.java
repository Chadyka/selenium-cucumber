package hu.unideb.inf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Optional;

public class CartPage {

    private static final String PAGE_URL = "http://tutorialsninja.com/demo/index.php?route=checkout/cart";

    private static final By CART_TOTAL = By.cssSelector("#content > div.row > div > table > tbody > tr:nth-child(4) > td:nth-child(2)");

    @FindBy(css = "#content > form > div > table > tbody > tr > td:nth-child(4) > div > span > button.btn.btn-primary")
    private WebElement updateButton;

    @FindBy(css = "#content > form > div > table > tbody > tr > td:nth-child(4) > div > input")
    private WebElement quantityInput;

    @FindBy(css = "#content > form > div > table > tbody > tr > td:nth-child(4) > div > span > button.btn.btn-danger")
    private WebElement removeButton;

    @FindBy(css = "#checkout-cart > div.alert.alert-success.alert-dismissible")
    private WebElement alertSuccess;

    @FindBy(css = "#checkout-cart > div.alert.alert-danger.alert-dismissible")
    private WebElement alertError;

    @FindBy(css = "#content > p")
    private WebElement emptyMessage;

    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
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

    public WebElement getUpdateButton() {
        return updateButton;
    }

    public WebElement getQuantityInput() {
        return quantityInput;
    }

    public WebElement getAlertSuccess() {
        return alertSuccess;
    }

    public WebElement getAlertError() {
        return alertError;
    }

    public WebElement getRemoveButton() {
        return removeButton;
    }

    public WebElement getEmptyMessage() {
        return emptyMessage;
    }
}
