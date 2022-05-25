package hu.unideb.inf.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CollectionStepDefs extends AbstractStepDefs {
    @When("the wishlist button is clicked")
    public void theWishlistButtonIsClicked() {
        collectionPage.getWishlistButton().click();
    }
    @Then("an error message with {string} is shown")
    public void anErrorMessageWithIsShown(String arg0) {
        Assert.assertTrue(collectionPage.getAlertMessage().getText().contains(arg0));
    }

    @When("the compare button is clicked")
    public void theCompareButtonIsClicked() {
        collectionPage.getCompareButton().click();
    }

    @When("the category button is clicked")
    public void theCategoryButtonIsClicked() {
        collectionPage.getCategoryButton().click();
    }

    @Then("the message {string} is shown")
    public void theMessageIsShown(String arg0) {
        Assert.assertTrue(collectionPage.getEmptyMessage().getText().contains(arg0));
    }

    @When("the currency selector selects GBP")
    public void theCurrencySelectorSelectsGBP() {
        collectionPage.getCurrencySelector().click();
        collectionPage.getGBPCurrencySelector().click();
    }

    @Then("the currency changes to GBP")
    public void theCurrencyChangesToGBP() {
        Assert.assertTrue(collectionPage.getProductPrice().getText().contains("£"));
    }
}
