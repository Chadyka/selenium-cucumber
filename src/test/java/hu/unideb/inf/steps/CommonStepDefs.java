package hu.unideb.inf.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonStepDefs extends AbstractStepDefs {
    @Given("the home page is opened")
    public void theHomePageIsOpened() {
        homePage.openPage();
    }
    @Given("the login page is opened")
    public void theLoginPageIsOpened() {
        loginPage.openPage();
    }

    @When("the cart page is opened")
    public void theCartPageIsOpened() {
        cartPage.openPage();
    }

    @Given("the forgot password page is opened")
    public void theForgotPasswordPageIsOpened() {
        forgotPasswordPage.openPage();
    }

    @Given("the collection page is opened")
    public void theCollectionPageIsOpened() {
        collectionPage.openPage();
    }

}
