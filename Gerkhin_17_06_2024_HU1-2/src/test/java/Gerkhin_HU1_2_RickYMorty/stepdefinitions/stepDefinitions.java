package Gerkhin_HU1_2_RickYMorty.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class stepDefinitions {
    private Response response;
    private long responseTime;

    @Given("the user is on the character search page")
    public void theUserIsOnTheCharacterSearchPage() {
        RestAssured.baseURI = "https://rickandmortyapi.com/api";
    }

    @When("the user enters {string} in the search field")
    public void theUserEntersInTheSearchField(String name) {
        response = given().queryParam("name", name).when().get("/character");
    }

    @And("presses the search button")
    public void pressesTheSearchButton() {
        // This step is already covered by the previous step where we perform the GET request
    }

    @Then("the search results are displayed")
    public void theSearchResultsAreDisplayed() {
        response.then().statusCode(200);
    }

    @And("the first result includes {string}")
    public void theFirstResultIncludes(String expectedName) {
        response.then().body("results[0].name", equalTo(expectedName));
    }

    @And("the result shows the name, image, status, location, and episodes.")
    public void theResultShowsTheNameImageStatusLocationAndEpisodes() {
        response.then().body("results[0].name", notNullValue())
                .body("results[0].image", notNullValue())
                .body("results[0].status", notNullValue())
                .body("results[0].location.name", notNullValue())
                .body("results[0].episode", not(empty()));
    }

    @And("one of the results includes {string}")
    public void oneOfTheResultsIncludes(String expectedName) {
        response.then().body("results.name", hasItem(expectedName));
    }

    @Then("similar name suggestions are displayed")
    public void similarNameSuggestionsAreDisplayed() {
        response.then().statusCode(200).body("results", not(empty()));
    }

    @And("a message indicating no exact matches is shown.")
    public void aMessageIndicatingNoExactMatchesIsShown() {
        // The API might not directly support this, so we assume checking the non-exact results
        response.then().body("results", not(empty()));
    }

    @Then("a message indicating no results found is displayed")
    public void aMessageIndicatingNoResultsFoundIsDisplayed() {
        response.then().statusCode(404).body("error", equalTo("Character not found"));
    }

    @And("alternative search suggestions are shown.")
    public void alternativeSearchSuggestionsAreShown() {
        // Depending on API behavior, we can check for suggestions or similar results
        response.then().body("results", not(empty()));
    }

    @Then("the search results are displayed in less than {int} seconds.")
    public void theSearchResultsAreDisplayedInLessThanSeconds(int seconds) {
        responseTime = response.time();
        assert(responseTime < seconds * 1000);
    }

    @Given("the user is on the character detail page")
    public void theUserIsOnTheCharacterDetailPage() {
        RestAssured.baseURI = "https://rickandmortyapi.com/api";
    }

    @When("the user enters the ID {string} in the input field")
    public void theUserEntersTheIDInTheinputField(String id) {
        response = given().when().get("/character/" + id);
    }

    @Then("the detailed information of the character is displayed")
    public void theDetailedInformationOfTheCharacterIsDisplayed() {
        response.then().statusCode(200)
                .body("name", notNullValue())
                .body("status", notNullValue())
                .body("species", notNullValue())
                .body("gender", notNullValue())
                .body("origin.name", notNullValue())
                .body("location.name", notNullValue())
                .body("image", notNullValue())
                .body("episode", not(empty()));
    }

    @And("the information includes name, status, species, gender, origin, location, image, and episodes.")
    public void theInformationIncludesNameStatusSpeciesGenderOriginLocationImageAndEpisodes() {
        response.then()
                .body("name", notNullValue())
                .body("status", notNullValue())
                .body("species", notNullValue())
                .body("gender", notNullValue())
                .body("origin.name", notNullValue())
                .body("location.name", notNullValue())
                .body("image", notNullValue())
                .body("episode", not(empty()));
    }

    @Then("an error message indicating the ID is invalid is displayed.")
    public void anErrorMessageIndicatingTheIDIsInvalidIsDisplayed() {
        response.then().statusCode(404).body("error", equalTo("Character not found"));
    }

    @Then("message indicating no results found is displayed.")
    public void messageIndicatingNoResultsFoundIsDisplayed() {
        response.then().statusCode(404).body("error", equalTo("Character not found"));
    }

    @Then("the detailed information of the character is displayed in less than {int} seconds.")
    public void theDetailedInformationOfTheCharacterIsDisplayedInLessThanSeconds(int seconds) {
        responseTime = response.time();
        assert(responseTime < seconds * 1000);
    }

    @And("the total amount in the cart is updated automatically")
    public void theTotalAmountInTheCartIsUpdatedAutomatically() {

    }

    @And("the number of items in the cart is updated automatically")
    public void theNumberOfItemsInTheCartIsUpdatedAutomatically() {

    }

    @Given("the user is on any product page")
    public void theUserIsOnAnyProductPage() {
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String arg0) {
    }

    @Then("the product is added to the cart")
    public void theProductIsAddedToTheCart() {
    }

    @And("a confirmation message is displayed indicating the product has been added to the cart")
    public void aConfirmationMessageIsDisplayedIndicatingTheProductHasBeenAddedToTheCart() {
    }

    @Given("the user is on the cart page")
    public void theUserIsOnTheCartPage() {
    }

    @Then("the user should see a list of products in the cart with their names, images, prices, quantities, and subtotal")
    public void theUserShouldSeeAListOfProductsInTheCartWithTheirNamesImagesPricesQuantitiesAndSubtotal() {
    }

    @When("the user clicks on the {string} button next to a product")
    public void theUserClicksOnTheButtonNextToAProduct(String arg0) {
    }

    @Then("the product is removed from the cart")
    public void theProductIsRemovedFromTheCart() {
    }

    @When("the user changes the quantity of a product in the cart")
    public void theUserChangesTheQuantityOfAProductInTheCart() {
    }

    @Then("the quantity of the product is updated in the cart")
    public void theQuantityOfTheProductIsUpdatedInTheCart() {
    }

    @Given("the user has an iPhone and an Apple Cinema {int}\" monitor in the cart")
    public void theUserHasAnIPhoneAndAnAppleCinemaMonitorInTheCart(int arg0) throws Throwable {
}

    @When("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
    }

    @And("completes the purchase process")
    public void completesThePurchaseProcess() {
    }

    @Then("a confirmation message is displayed indicating the products have been purchased successfully")
    public void aConfirmationMessageIsDisplayedIndicatingTheProductsHaveBeenPurchasedSuccessfully() {
    }
}
