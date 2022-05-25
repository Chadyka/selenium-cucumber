package hu.unideb.inf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Optional;

public class ForgotPasswordPage {

    private static final String PAGE_URL = "http://tutorialsninja.com/demo/index.php?route=account/forgotten";

    @FindBy(id = "input-email")
    private WebElement emailField;

    @FindBy(css = "#content > form > div > div.pull-right > input")
    private WebElement submitForm;

    @FindBy(css = "#account-forgotten > div.alert.alert-danger.alert-dismissible")
    private WebElement errorMessage;

    private final WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
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

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public WebElement getSubmitForm() {
        return submitForm;
    }
}
