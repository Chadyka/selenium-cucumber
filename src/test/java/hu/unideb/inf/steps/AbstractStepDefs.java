package hu.unideb.inf.steps;

import hu.unideb.inf.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public abstract class AbstractStepDefs {

    private static final int WAIT_TIME = 10;
    static WebDriver driver;
    protected static HomePage homePage;

    protected static CartPage cartPage;

    protected static LoginPage loginPage;

    protected static ForgotPasswordPage forgotPasswordPage;
    protected static CollectionPage collectionPage;

    static {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        loginPage = new LoginPage(driver);
        collectionPage = new CollectionPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
    }

}
