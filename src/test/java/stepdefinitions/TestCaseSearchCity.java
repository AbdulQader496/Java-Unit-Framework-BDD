package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.MainPage;
import pages.SearchResultPage;
import pages.WeatherLocationPage;
import utils.SettingsTestData;

import static io.qameta.allure.Allure.step;

public class TestCaseSearchCity {

    private MainPage mainPage = new MainPage();
    private SearchResultPage searchResultPage= new SearchResultPage();
    private WeatherLocationPage weatherLocationPage = new WeatherLocationPage();

    @When("Enter {string} in search text box")
    public void enterCityName(String city) {
        step("enter the city name");
        mainPage.inputText(city);
    }

    @Then("I choose the location from the list and the weather of New York is displayed")
    public void clickLocation() {
        step("Choosing the city from the list");
        searchResultPage.clickLocation();
//        step("Dismiss popup");
//        searchResultPage.clickPopupDismissBtn();
        step("Verify if the actual and expected location are same");
        Assert.assertEquals(weatherLocationPage.actualLocation(), SettingsTestData.getExpectedLocationData().getExpectedLocation(), "Location is not same");
    }

}
