package hu.unideb.inf.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class CartStepDefs extends AbstractStepDefs {
    @When("the MacBook is added to cart")
    public void theMacBookIsAddedToCart() {
        homePage.getAddToCartButton().click();
    }

    @Then("the cart total is {string}")
    public void theCartTotalIs(String arg0) {
        Optional<String> errorMessage = homePage.getCartTotal();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(arg0, errorMessage.get());
        } else {
            fail();
        }
    }

    @And("the quantity field is filled with {string}")
    public void theQuantityFieldIsFilledWith(String arg0) {
        cartPage.getQuantityInput().clear();
        cartPage.getQuantityInput().sendKeys(arg0);
    }

    @And("the quantity update button is clicked")
    public void theQuantityUpdateButtonIsClicked() {
        cartPage.getUpdateButton().click();
    }

    @Then("the cart page total is {string}")
    public void theCartPageTotalIs(String arg0) {
        Optional<String> errorMessage = cartPage.getCartTotal();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(arg0, errorMessage.get());
        } else {
            fail();
        }
    }

    @Then("the update successful message {string} is shown")
    public void theUpdateSuccessfulMessageIsShown(String arg0) {
        Assert.assertTrue(cartPage.getAlertSuccess().getText().contains(arg0));
    }

    @Then("the update error message {string} is shown")
    public void theUpdateErrorMessageIsShown(String arg0) {
        Assert.assertTrue(cartPage.getAlertError().getText().contains(arg0));
    }

    @And("the remove button is clicked")
    public void theRemoveButtonIsClicked() {
        cartPage.getRemoveButton().click();
    }

    @Then("the empty cart message is shown {string}")
    public void theEmptyCartMessageIsShown(String arg0) {
        System.out.println(cartPage.getEmptyMessage().getText());
        System.out.println(arg0);
        Assert.assertTrue(cartPage.getEmptyMessage().getText().contains(arg0));
    }
}
