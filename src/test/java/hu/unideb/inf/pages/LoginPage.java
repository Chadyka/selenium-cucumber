package hu.unideb.inf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Optional;

public class LoginPage {

    private static final String PAGE_URL = "http://tutorialsninja.com/demo/index.php?route=account/login";

    @FindBy(id = "input-email")
    private WebElement emailField;

    @FindBy(css = "#content > div > div:nth-child(2) > div > form > input")
    private WebElement submitLogin;

    @FindBy(css = "#account-login > div.alert.alert-danger.alert-dismissible")
    private WebElement errorMessage;

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
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

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getSubmitLogin() {
        return submitLogin;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }
}
