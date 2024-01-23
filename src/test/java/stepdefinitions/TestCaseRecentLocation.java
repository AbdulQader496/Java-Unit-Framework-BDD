package stepdefinitions;

import aquality.selenium.browser.AqualityServices;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.MainPage;
import pages.SearchResultPage;
import pages.WeatherLocationPage;
import utils.SettingsTestData;

import static io.qameta.allure.Allure.step;

public class TestCaseRecentLocation {
    private MainPage mainPage = new MainPage();
    private SearchResultPage searchResultPage = new SearchResultPage();
    private WeatherLocationPage weatherLocationPage = new WeatherLocationPage();

    @When("I Enter {string} in search text box")
    public void enterCityName(String city) {
        step("enter the city name");
        mainPage.inputText(city);
    }

    @Then("I choose the location from the list and the weather of London is displayed")
    public void clickLocation() {
        step("Choosing the city from the list");
        searchResultPage.clickLocationLondon();
    }

    @And("I go back to Main page")
    public void goToMainPage() {
        step("going to previous page");
        AqualityServices.getBrowser().goBack();
        step("going to previous page");
        AqualityServices.getBrowser().goBack();
    }

    @When("I choose the first city in the Recent location and the weather is displayed")
    public void clickRecentLocation() {
        step("Clicking on the recent city location");
        mainPage.recentLocation();
//        mainPage.clickPopupDismissBtn();
        step("Verify if the actual and expected recent location are same");
        Assert.assertEquals(weatherLocationPage.actualRecentLocation(), SettingsTestData.getExpectedLocationData().getExpectedRecentLocation(), "Location is not same");
    }
}
