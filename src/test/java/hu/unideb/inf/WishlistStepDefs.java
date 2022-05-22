package hu.unideb.inf;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class WishlistStepDefs extends AbstractStepDefs {
    @When("^the wishlist button is clicked$")
    public void theWishlistButtonIsClicked() {
        homePage.getWishlistButton().click();
    }

    @Then("a {string} error message is shown")
    public void aErrorMessageIsShown(String arg0) {
        Optional<String> errorMessage = homePage.getWishlistError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(arg0, errorMessage.get());
        } else {
            fail();
        }
    }


}
