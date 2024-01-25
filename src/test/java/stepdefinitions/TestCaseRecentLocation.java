package stepdefinitions;

import aquality.selenium.browser.AqualityServices;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
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
    public String enterCityName(String city) {
        step("enter the city name");
        mainPage.inputText(city);
        return city;
    }

    @When("I Click on the first result")
    public void clickLocation() {
        step("Choosing the city from the list");
        mainPage.selectLocation();
    }

    @And("I go back to Main page")
    public void goToMainPage() {
        step("going to main page");
        weatherLocationPage.toMainPage();
    }

    @Then("main page is displayed")
    public void verifyMAinPage() {
        Assert.assertTrue(mainPage.isHomePage(),"You are not in home page");
    }

    @When("I choose the first city in the Recent location")
    public void clickRecentLocation() {
        step("Clicking on the recent city location");
        mainPage.recentLocation();
        mainPage.clickPopupDismissBtn();
    }

    @Then("City weather page header contains city name from the Recent search")
    public void verifyLocation() {
        step("Verify if the actual and expected recent location are same");
        Assert.assertEquals(weatherLocationPage.actualLocation(), SettingsTestData.getExpectedLocationData().getExpectedRecentLocation(), "Location is not same");
    }
}
