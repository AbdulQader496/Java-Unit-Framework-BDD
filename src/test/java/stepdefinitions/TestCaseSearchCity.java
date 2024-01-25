package stepdefinitions;

import aquality.selenium.browser.Browser;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.MainPage;
import pages.SearchResultPage;
import pages.WeatherLocationPage;
import utils.SettingsTestData;
import org.openqa.selenium.interactions.Actions;
import static io.qameta.allure.Allure.step;

public class TestCaseSearchCity {

    private MainPage mainPage = new MainPage();
    private SearchResultPage searchResultPage= new SearchResultPage();
    private WeatherLocationPage weatherLocationPage = new WeatherLocationPage();
    Browser browser;


    @When("Enter {string} in search field")
    public String enterCityName(String city) {
        step("enter the city name");
        mainPage.inputText(city);
        return city;
    }

    @Then("Search result is displayed")
    public void listOfSearchedCity() {
        Assert.assertTrue(mainPage.isSearchResultDisplayed(),"Result page is not displayed");
    }

    @When("Click on the first search result")
    public void clickLocation() {
        step("Choosing the city from the list");
        mainPage.selectLocation();
    }

    @Then("City weather page header contains city name from the search")
    public void verifyLocation() {
        step("Verify if the actual and expected location are same");
        Assert.assertEquals(weatherLocationPage.actualLocation(), SettingsTestData.getExpectedLocationData().getExpectedLocation(), "Location is not same");
    }


}
