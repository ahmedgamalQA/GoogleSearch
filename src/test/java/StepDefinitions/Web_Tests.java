package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static StepDefinitions.Hooks.driver;

import Pages.*;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Web_Tests {
    GoogleHomePage googleHomePage = new GoogleHomePage(driver);
    SearchPage searchPage = new SearchPage(driver);
    SoftAssert soft = new SoftAssert();
    MorePage morePage = new MorePage(driver);


    @Given("User opens Google Search")
    public void userOpensGoogleSearch() {

    }

    @When("enters the query {string} in the search bar")
    public void entersTheQueryInTheSearchBar(String KeySearch1) {
        googleHomePage.SearchOnGoogle(KeySearch1);
    }

    @And("click on search button")
    public void clickOnSearchButton() {
        googleHomePage.ClickOnSearchButton();
    }

    @Then("the search results should display is {string} or {string} or {string}")
    public void theSearchResultsShouldDisplayFlightOptionsIs(String ExpectedResultValue1, String ExpectedResultValue2, String ExpectedResultValue3) {
        List<String> searchResults = searchPage.extractDataFromElements();
        // Normalize the expected result values (convert them to lowercase for comparison)
        String expectedValue1 = ExpectedResultValue1.toLowerCase().trim();
        String expectedValue2 = ExpectedResultValue2.toLowerCase().trim();
        String expectedValue3 = ExpectedResultValue3.toLowerCase().trim();
        // Loop through the results and normalize the actual result
        for (String result : searchResults) {
            // Normalize actual result by converting to lowercase and trimming spaces
            String normalizedResult = result.trim().toLowerCase();
            // Print the normalized result for debugging
            System.out.println("Normalized result: " + normalizedResult);
            // Check if any of the normalized expected values are found in the normalized result
            boolean found =
                    normalizedResult.contains(expectedValue1) ||
                            normalizedResult.contains(expectedValue2) ||
                            normalizedResult.contains(expectedValue3);
            // Assert that at least one of the expected values is found
            soft.assertTrue(found, "None of the expected values found in: " + result);
        }
        // Ensure all assertions are checked
        soft.assertAll();
    }

    @And("Assert the header of the page is {string}")
    public void assertTheHeaderOfThePageIs(String ExpectedHeaderValue) {
        soft.assertTrue(searchPage.GetTextOfHeader().contains(ExpectedHeaderValue));

        System.out.println("Actual Headeris :" + searchPage.GetTextOfHeader());
        soft.assertAll();
    }
    @When("navigate to more page then filter by top Rate {string}")
    public void navigateToMorePageThenFilterByTopRate(String rate){
        searchPage.clickOnMorePlacesLink();
        morePage.FilterByRatingOptions(rate);
    }

    @And("Assert that all result items more than or equal {double}")
    public void assertThatAllResultItemsMoreThanOrEqual(double ExpectedRate) {
        // Extract the list of ratings from the page
        List<String> rateResults = morePage.extractRateFromItems();

        // Iterate through the ratings and assert each one
        for (String rate : rateResults) {
            // Parse the rating as a double
            double actualRate = Double.parseDouble(rate);

            // Print the rating for debugging purposes
            System.out.println("Found rating: " + actualRate);

            // Assert that the rating is greater than or equal to the expected rate
            soft.assertTrue(
                    actualRate >= ExpectedRate,
                    "Rating " + actualRate + " is less than the expected threshold of " + ExpectedRate
            );
        }
        // Ensure all assertions are checked
        soft.assertAll();
    }
}
