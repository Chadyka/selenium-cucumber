package hu.unideb.inf.steps;

import hu.unideb.inf.steps.AbstractStepDefs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ForgotPasswordStepDefs extends AbstractStepDefs {
    @Given("the forgotten email field is filled with {string}")
    public void theForgottenEmailFieldIsFilledWithParameter(String arg0) {
        forgotPasswordPage.getEmailField().clear();
        forgotPasswordPage.getEmailField().sendKeys(arg0);
    }

    @When("the forgotten page Sign In button is clicked")
    public void theForgottenPageSignInButtonIsClicked() {
        forgotPasswordPage.getSubmitForm().click();
    }

    @Then("the {string} error message is shown on the forgotten password page")
    public void theMsgErrorMessageIsShownOnTheForgottenPasswordPage(String arg0) {
        Assert.assertTrue(forgotPasswordPage.getErrorMessage().getText().contains(arg0));
    }
}
