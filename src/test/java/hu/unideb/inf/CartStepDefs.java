package hu.unideb.inf;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class CartStepDefs extends AbstractStepDefs{
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
}
