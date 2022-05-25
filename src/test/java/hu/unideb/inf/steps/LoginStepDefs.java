package hu.unideb.inf.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs extends AbstractStepDefs {

    @Given("the email field is filled with {string}")
    public void theFieldIsFilledWithParameter(String arg0) {
        loginPage.getEmailField().clear();
        loginPage.getEmailField().sendKeys(arg0);
    }

    @When("the Sign In button is clicked")
    public void theSignInButtonIsClicked() {
        loginPage.getSubmitLogin().click();
    }

    @Then("the {string} error message is shown")
    public void theMsgErrorMessageIsShown(String arg0) {
        Assert.assertTrue(loginPage.getErrorMessage().getText().contains(arg0));
    }
}
