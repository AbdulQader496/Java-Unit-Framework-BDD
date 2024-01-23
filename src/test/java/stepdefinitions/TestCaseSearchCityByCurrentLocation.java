package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.MainPage;
import utils.SettingsTestData;

import static io.qameta.allure.Allure.step;

public class TestCaseSearchCityByCurrentLocation {

    private MainPage mainPage = new MainPage();

    @When("I click on the search text box")
    public void clickOnSearchTextBox() {
        step("Clicking on the search field");
        mainPage.clickSearchBox();
    }

    @Then("I will see the use you current location option")
    public void verifyUseCurrentLocationOption() {
        step(" verify if the option is right");
        mainPage.useCurrentLocationOption();
        Assert.assertEquals(mainPage.useCurrentLocationOption(), SettingsTestData.getExpectedOptionData().getExpectedOption(), "Option is not same");
    }


}
