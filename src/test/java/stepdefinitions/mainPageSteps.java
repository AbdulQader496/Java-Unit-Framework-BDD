package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.MainPage;

import static io.qameta.allure.Allure.step;

public class mainPageSteps {

    private MainPage mainPage = new MainPage();

    @Given("I go to the Main Page and I Consent data usage")
    public void FinalTask() {
        step("Consent to data usage");
        mainPage.clickConsentBtn();

    }
}
